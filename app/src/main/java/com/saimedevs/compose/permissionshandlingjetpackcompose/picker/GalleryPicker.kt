package com.saimedevs.compose.permissionshandlingjetpackcompose.picker

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryPicker(
    modifier: Modifier = Modifier,
   // state: GalleryPickerState = rememberGalleryPickerState(),
    lazyGridState: LazyStaggeredGridState = rememberLazyStaggeredGridState(),
    backgroundColor: Color = Color.Black,
    onImageSelected: (Uri) -> Unit,
) {
    val context = LocalContext.current

    val photos = rememberMediaPhotos(context = context)
    LazyVerticalStaggeredGrid(
        modifier = modifier
            .background(backgroundColor)
           // .padding(horizontal = state.horizontalPadding.dp)
            .fillMaxWidth(),
        state = lazyGridState,
        columns = StaggeredGridCells.Fixed(3)
    ) {
        itemsIndexed(
            items = photos
        ) { _, photo ->
            val shape = RoundedCornerShape(10.dp)
            Card(
                shape = shape,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = shape)
                    .padding(5.dp),
                onClick = { onImageSelected(photo.uri) }
            ) {
                AsyncImage(
                    modifier = Modifier
                      // .aspectRatio(photo.size.width / photo.size.height)
                        .height(200.dp)
                        //.heightIn(min = state.itemMinHeight.dp, max = state.itemMaxHeight.dp)
                        .fillMaxWidth(),
                    model = photo.uri,
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        }
    }
}
