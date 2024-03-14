package com.sleepingcat.hencodercompose.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarMenuView
import com.sleepingcat.hencodercompose.R
import com.sleepingcat.hencodercompose.utils.AppConfig
import px

@SuppressLint("RestrictedApi")
class AppBottomBar(context: Context, attrs: AttributeSet?) : BottomNavigationView(context, attrs) {
    private val mIcons = intArrayOf(
        R.drawable.icon_tab_main,
        R.drawable.icon_tab_category,
        R.drawable.icon_tab_publish,
        R.drawable.icon_tab_tags,
        R.drawable.icon_tab_user
    )

    init {
        val config = AppConfig.getBottomBarConfig()
        val states = arrayOfNulls<IntArray>(2)
        states[0] = IntArray(1) { android.R.attr.state_selected }
        states[1] = IntArray(1)
        val colorStates = IntArray(2)
        colorStates[0] = Color.parseColor(config.activeColor)
        colorStates[1] = Color.parseColor(config.inActiveColor)
        val colorStatesList = ColorStateList(states, colorStates)
        itemTextColor = colorStatesList
        itemIconTintList = colorStatesList
        //LABEL_VISIBILITY_LABELED:设置按钮的文本为一直显示模式
        //LABEL_VISIBILITY_AUTO:当按钮个数小于三个时一直显示，或者当按钮个数大于3个且小于5个时，被选中的那个按钮文本才会显示
        //LABEL_VISIBILITY_SELECTED：只有被选中的那个按钮的文本才会显示
        //LABEL_VISIBILITY_UNLABELED:所有的按钮文本都不显示
        labelVisibilityMode = LABEL_VISIBILITY_LABELED

        config.tabs.forEachIndexed { index, tab ->
            if (!tab.enable) {
                return@forEachIndexed
            }
            val menuItem = menu.add(0, tab.route.hashCode(), tab.index, tab.title)
            menuItem.setIcon(mIcons[index])
        }

        clipChildren = false
        val navigationBarMenuView = menuView as NavigationBarMenuView
        navigationBarMenuView.clipChildren = false
        config.tabs.forEachIndexed { index, tab ->
            val iconSize = tab.size.px
            // 不能用这个api，这个api效果是全部icon设置统一大小，所以最后的icon是多大，整体就有多大
//            itemIconSize = iconSize.toInt()
            // 要单独给每个item设置
            val itemView = navigationBarMenuView.getChildAt(index) as BottomNavigationItemView
            itemView.setIconSize(iconSize.toInt())
            if (TextUtils.isEmpty(tab.title)) {
                itemView.setIconTintList(ColorStateList.valueOf(colorStates[0]))
                post {
                    // 这个post是等View绘制完了再移动
                    itemView.scrollBy(0, 20.px.toInt())
                }
            }
        }
        if(config.selectTab >= 0){
            val tab = config.tabs[config.selectTab]
            val itemId = tab.route.hashCode()
            post {
                selectedItemId = itemId
            }
        }
    }
}