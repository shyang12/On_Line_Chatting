package kr.ac.seokyeong.on_line_chatting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import kr.ac.seokyeong.on_line_chatting.databinding.ActivityVideoBinding
import com.remotemonster.sdk.RemonCall




class VideoActivity : AppCompatActivity() {
    lateinit var binding : ActivityVideoBinding
    var remonCall : RemonCall? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        remonCall = RemonCall.builder()
            .context(this)
            .serviceId("SERVICEID1")
            .key("1234567890")
            .videoCodec("VP8")
            .videoWidth(640)
            .videoHeight(480)
            .localView(binding.localView)
            .remoteView(binding.remoteView)
            .build()

        val channelId = intent.getStringExtra("channelId")
        remonCall?.connect(channelId)
        remonCall?.onClose {
            finish()
        }

    }
    override fun onDestroy() {
        remonCall?.close()
        super.onDestroy()
    }
}