package com.xquare.androidv2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup.MarginLayoutParams
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import com.xquare.androidv2.databinding.ActivityRootBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class RootActivity : AppCompatActivity() {
    private val viewModel: RootViewModel by viewModel()
    private val binding by lazy { ActivityRootBinding.inflate(LayoutInflater.from(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initSystemBars()
        initEdgeToEdge()
    }

    // todo move to utils
    private fun initSystemBars() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.apply {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            )
        }
    }

    // todo move to utils
    private fun initEdgeToEdge() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, windowInsets ->
            windowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).let { insets ->
                view.updateLayoutParams<MarginLayoutParams> {
                    leftMargin = insets.left
                    bottomMargin = insets.bottom
                    rightMargin = insets.right
                    topMargin = insets.top
                }
            }

            WindowInsetsCompat.CONSUMED
        }
    }
}
