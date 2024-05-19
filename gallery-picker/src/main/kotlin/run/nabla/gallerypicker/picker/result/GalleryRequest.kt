@file:Suppress("unused")

package run.nabla.gallerypicker.picker.result

import androidx.annotation.FontRes
import androidx.compose.ui.graphics.Color
import run.nabla.gallerypicker.R
import run.nabla.gallerypicker.picker.DEFAULT_GRID_COLUMNS
import run.nabla.gallerypicker.picker.DEFAULT_HORIZONTAL_PADDING
import run.nabla.gallerypicker.picker.DEFAULT_ITEM_MAX_HEIGHT
import run.nabla.gallerypicker.picker.DEFAULT_ITEM_MIN_HEIGHT
import run.nabla.gallerypicker.picker.DEFAULT_ITEM_ROUNDED_CORNER_SIZE

class GalleryRequest internal constructor() {

    @FontRes
    var fontFamily: Int = 0
        internal set
    var backgroundColor: Long = Color.Black.value.toLong()
        internal set
    var titleColor: Long = Color.White.value.toLong()
        internal set


    var title: String = ""
        internal set

    var titleSize: Int = 20
        internal set

    var showExitAction: Boolean = true
        internal set

    var horizontalPadding: Int = DEFAULT_HORIZONTAL_PADDING
        internal set

    var itemsRoundedCornerSize: Int = DEFAULT_ITEM_ROUNDED_CORNER_SIZE
        internal set
    var gridColumns: Int = DEFAULT_GRID_COLUMNS
        internal set
    var itemMinHeight: Int = DEFAULT_ITEM_MIN_HEIGHT
        internal set
    var itemMaxHeight: Int = DEFAULT_ITEM_MAX_HEIGHT
        internal set

    var permissionTitle: String = ""
        internal set
    var permissionTitleColor: Long = Color.Black.value.toLong()
        internal set
    var permissionBodyColor: Long = Color.Gray.value.toLong()
        internal set
    var permissionBackgroundColor: Long = Color.White.value.toLong()
        internal set
    var permissionImage: Int = R.drawable.ic_permission_unlock
        internal set
    var permissionPrimaryActionTitle: String = ""
        internal set
    var permissionPrimaryActionColor: Long = Color.White.value.toLong()
        internal set
    var permissionPrimaryActionBackgroundColor: Long =
        Color.Black.value.toLong()
        internal set
    var permissionSecondaryActionTitle: String = ""
        internal set
    var permissionSecondaryActionColor: Long = Color.Black.value.toLong()
        internal set
    var permissionSecondaryActionBackgroundColor: Long =
        Color.White.value.toLong()
        internal set
    var permissionSecondaryActionBorderColor: Long =
        Color.Black.value.toLong()
        internal set

    /**
     * A builder for constructing [GalleryRequest] instances.
     */
    class Builder {

        private var fontFamily: Int = 0

        private var backgroundColor: Long = Color.Black.value.toLong()

        private var titleColor: Long = Color.White.value.toLong()

        private var titleSize: Int = 20

        private var title: String = ""

        private var showExitAction: Boolean = true

        private var horizontalPadding: Int = DEFAULT_HORIZONTAL_PADDING

        private var itemsRoundedCornerSize: Int = DEFAULT_ITEM_ROUNDED_CORNER_SIZE

        private var gridColumns: Int = DEFAULT_GRID_COLUMNS

        private var itemMinHeight: Int = DEFAULT_ITEM_MIN_HEIGHT

        private var itemMaxHeight: Int = DEFAULT_ITEM_MAX_HEIGHT

        private var permissionTitle: String = ""

        private var permissionTitleColor: Long = Color.Black.value.toLong()

        private var permissionBody: String = ""

        private var permissionBodyColor: Long = Color.Gray.value.toLong()

        private var permissionBackgroundColor: Long = Color.White.value.toLong()

        private var permissionImage: Int = R.drawable.ic_permission_unlock

        private var permissionPrimaryActionTitle: String = ""

        private var permissionPrimaryActionColor: Long = Color.White.value.toLong()

        private var permissionPrimaryActionBackgroundColor: Long =
            Color.Black.value.toLong()

        private var permissionSecondaryActionTitle: String = ""

        private var permissionSecondaryActionColor: Long = Color.Black.value.toLong()

        private var permissionSecondaryActionBackgroundColor: Long =
            Color.White.value.toLong()

        private var permissionSecondaryActionBorderColor: Long =
            Color.Black.value.toLong()


        /**
         * Set the font family for the screen.
         *
         * @param fontFamily the font family to set.
         * @return This builder.
         */
        fun setFontFamily(fontFamily: Int): Builder {
            this.fontFamily = fontFamily
            return this
        }

        /**
         * Set the background color for the screen.
         *
         * @param color the background color to set.
         * @return This builder.
         */
        fun setBackgroundColor(color: Long): Builder {
            this.backgroundColor = color
            return this
        }

        /**
         * Set the title color for the screen.
         *
         * @param color the title color to set.
         * @return This builder.
         */
        fun setTitleColor(color: Long): Builder {
            this.titleColor = color
            return this
        }

        /**
         * Set the title size for the screen.
         *
         * @param size the title size to set.
         * @return This builder.
         */
        fun setTitleSize(size: Int): Builder {
            this.titleSize = size
            return this
        }

        /**
         * Set the header title for the [GalleryRequest].
         *
         * @param title header title to go into the GalleryRequest
         * @return This builder.
         */
        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        /**
         * Set whether to show the back button on the screen.
         *
         * @param show true to show the back button, false otherwise.
         * @return This builder.
         */
        fun showExitAction(show: Boolean): Builder {
            this.showExitAction = show
            return this
        }

        /**
         * Set the horizontal padding for the layout in the GalleryRequest.
         *
         * @param padding The horizontal padding value to set.
         * @return This builder.
         */
        fun setHorizontalPadding(padding: Int): Builder {
            this.horizontalPadding = padding
            return this
        }

        /**
         * Set the rounded corner size for the items in the GalleryRequest.
         *
         * @param size The rounded corner size to set.
         * @return This builder.
         */
        fun setItemsRoundedCornerSize(size: Int): Builder {
            this.itemsRoundedCornerSize = size
            return this
        }

        /**
         * Set the number of grid columns for the GalleryRequest.
         *
         * @param columns The number of grid columns to set.
         * @return This builder.
         */
        fun setGridColumns(columns: Int): Builder {
            this.gridColumns = columns
            return this
        }

        /**
         * Set the minimum height for the items in the GalleryRequest.
         *
         * @param height The minimum height value to set.
         * @return This builder.
         */
        fun setItemMinHeight(height: Int): Builder {
            this.itemMinHeight = height
            return this
        }

        /**
         * Set the maximum height for the items in the GalleryRequest.
         *
         * @param height The maximum height value to set.
         * @return This builder.
         */
        fun setItemMaxHeight(height: Int): Builder {
            this.itemMaxHeight = height
            return this
        }

        /**
         * Set the permission title in the GalleryRequest.
         *
         * @param title The permission title to set.
         * @return This builder.
         */
        fun setPermissionTitle(title: String): Builder {
            this.permissionTitle = title
            return this
        }

        /**
         * Set the permission title color in the GalleryRequest.
         *
         * @param color The permission title color to set.
         * @return This builder.
         */
        fun setPermissionTitleColor(color: Long): Builder {
            this.permissionTitleColor = color
            return this
        }

        /**
         * Set the permission body in the GalleryRequest.
         *
         * @param body The permission body to set.
         * @return This builder.
         */
        fun setPermissionBody(body: String): Builder {
            this.permissionBody = body
            return this
        }

        /**
         * Set the permission body color in the GalleryRequest.
         *
         * @param color The permission body color to set.
         * @return This builder.
         */
        fun setPermissionBodyColor(color: Long): Builder {
            this.permissionBodyColor = color
            return this
        }

        /**
         * Set the permission background color in the GalleryRequest.
         *
         * @param color The permission background color to set.
         * @return This builder.
         */
        fun setPermissionBackgroundColor(color: Long): Builder {
            this.permissionBackgroundColor = color
            return this
        }

        /**
         * Set the permission image in the GalleryRequest.
         *
         * @param image The permission image to set.
         * @return This builder.
         */
        fun setPermissionImage(image: Int): Builder {
            this.permissionImage = image
            return this
        }

        /**
         * Set the permission primary action title in the GalleryRequest.
         *
         * @param title The permission primary action title to set.
         * @return This builder.
         */
        fun setPermissionPrimaryActionTitle(title: String): Builder {
            this.permissionPrimaryActionTitle = title
            return this
        }

        /**
         * Set the permission primary action color in the GalleryRequest.
         *
         * @param color The permission primary action color to set.
         * @return This builder.
         */
        fun setPermissionPrimaryActionColor(color: Long): Builder {
            this.permissionPrimaryActionColor = color
            return this
        }

        /**
         * Set the permission primary action background color in the GalleryRequest.
         *
         * @param color The permission primary action background color to set.
         * @return This builder.
         */
        fun setPermissionPrimaryActionBackgroundColor(color: Long): Builder {
            this.permissionPrimaryActionBackgroundColor = color
            return this
        }

        /**
         * Set the permission secondary action title in the GalleryRequest.
         *
         * @param title The permission secondary action title to set.
         * @return This builder.
         */
        fun setPermissionSecondaryActionTitle(title: String): Builder {
            this.permissionSecondaryActionTitle = title
            return this
        }

        /**
         * Set the permission secondary action color in the GalleryRequest.
         *
         * @param color The permission secondary action color to set.
         * @return This builder.
         */
        fun setPermissionSecondaryActionColor(color: Long): Builder {
            this.permissionSecondaryActionColor = color
            return this
        }

        /**
         * Set the permission secondary action background color in the GalleryRequest.
         *
         * @param color The permission secondary action background color to set.
         * @return This builder.
         */
        fun setPermissionSecondaryActionBackgroundColor(color: Long): Builder {
            this.permissionSecondaryActionBackgroundColor = color
            return this
        }

        /**
         * Set the permission secondary action border color in the GalleryRequest.
         *
         * @param color The permission secondary action border color to set.
         * @return This builder.
         */
        fun setPermissionSecondaryActionBorderColor(color: Long): Builder {
            this.permissionSecondaryActionBorderColor = color
            return this
        }

        /**
         * Build the GalleryRequest specified by this builder.
         *
         * @return the newly constructed GalleryRequest.
         */
        fun build(): GalleryRequest = GalleryRequest().apply {
            this.fontFamily = this@Builder.fontFamily
            this.backgroundColor = this@Builder.backgroundColor
            this.titleColor = this@Builder.titleColor
            this.title = this@Builder.title
            this.titleSize = this@Builder.titleSize
            this.showExitAction = this@Builder.showExitAction
            this.horizontalPadding = this@Builder.horizontalPadding
            this.itemsRoundedCornerSize = this@Builder.itemsRoundedCornerSize
            this.gridColumns = this@Builder.gridColumns
            this.itemMinHeight = this@Builder.itemMinHeight
            this.itemMaxHeight = this@Builder.itemMaxHeight

            this.permissionTitle = this@Builder.permissionTitle
            this.permissionTitleColor = this@Builder.permissionTitleColor
            this.permissionBodyColor = this@Builder.permissionBodyColor
            this.permissionBackgroundColor = this@Builder.permissionBackgroundColor
            this.permissionImage = this@Builder.permissionImage
            this.permissionPrimaryActionTitle = this@Builder.permissionPrimaryActionTitle
            this.permissionPrimaryActionColor = this@Builder.permissionPrimaryActionColor
            this.permissionPrimaryActionBackgroundColor =
                this@Builder.permissionPrimaryActionBackgroundColor
            this.permissionSecondaryActionTitle = this@Builder.permissionSecondaryActionTitle
            this.permissionSecondaryActionColor = this@Builder.permissionSecondaryActionColor
            this.permissionSecondaryActionBackgroundColor =
                this@Builder.permissionSecondaryActionBackgroundColor
            this.permissionSecondaryActionBorderColor =
                this@Builder.permissionSecondaryActionBorderColor
        }
    }
}
