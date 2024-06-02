package ani.saito.downloadAddon

import android.content.Context
import android.net.Uri
import android.util.Log
import ani.saito.addons.download.DownloadAddonApiV2
import com.arthenica.ffmpegkit.*
import kotlin.Pair
import kotlin.Unit
import kotlin.coroutines.Continuation
import kotlin.jvm.functions.Function1

class DownloadAddon : DownloadAddonApiV2 {
    override fun cancelDownload(sessionId: Long) {
        FFmpegKit.cancel(sessionId)
    }

    override suspend fun customFFMpeg(
        command: String,
        videoUrls: List<String>,
        logCallback: Function1<String, Unit>
    ): Long {
        TODO("Not yet implemented")
    }

    override suspend fun customFFProbe(
        command: String,
        videoUrls: List<String>,
        logCallback: Function1<String, Unit>
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun executeFFMpeg(
        videoUrl: String,
        downloadPath: String,
        headers: Map<String, String>,
        subtitleUrls: List<Pair<String, String>>,
        audioUrls: List<Pair<String, String>>,
        statCallback: (Double) -> Unit,
        continuation: Continuation<Long>
    ): Long {
        val downloadBuilder = DownloadBuilder()
        downloadBuilder.setDownloadPath(downloadPath)
        downloadBuilder.setVideoLink(videoUrl)
        downloadBuilder.setHeaders(headers)
        downloadBuilder.setSubtitleLinks(subtitleUrls)
        downloadBuilder.setAudioLinks(audioUrls)
        return FFmpegKit.executeAsync(
            downloadBuilder.buildDownload(),
            FFmpegSessionCompleteCallback { session -> executeFFMpegCallback(session) },
            LogCallback { log -> executeFFMpegLogCallback(log) },
            StatisticsCallback { stats -> executeFFMpegStatisticsCallback(statCallback, stats) }
        ).sessionId
    }

    private fun executeFFMpegCallback(ffmpegSession: FFmpegSession) {
        val state = ffmpegSession.state
        requireNotNull(state) { "getState(...)" }
        Log.d(
            "FFmpegKit",
            "FFmpeg process exited with state $state and rc ${ffmpegSession.returnCode}. ${ffmpegSession.failStackTrace}"
        )
    }

    private fun executeFFMpegLogCallback(log: com.arthenica.ffmpegkit.Log) {
        Log.d("FFmpegKit", log.message)
    }


    private fun executeFFMpegStatisticsCallback(statCallback: (Double) -> Unit, statistics: Statistics) {

        statCallback.invoke(statistics.bitrate)
    }

    override suspend fun executeFFProbe(
        command: String,
        videoUrls: Map<String, String>,
        logCallback: Function1<String, Unit>,
        continuation: Continuation<Unit>
    ) {
        val downloadBuilder = DownloadBuilder()
        downloadBuilder.setVideoLink(command)
        downloadBuilder.setHeaders(videoUrls) // Here, use `videoUrls` directly instead of `map`
        FFprobeKit.executeAsync(
            downloadBuilder.buildProbe(),
            FFprobeSessionCompleteCallback { session -> executeFFProbeCallback(session) },
            LogCallback { log -> executeFFProbeLogCallback(logCallback, log) }
        )
    }
    private fun executeFFProbeCallback(ffprobeSession: FFprobeSession) {
        Log.d("FFmpegKit", ffprobeSession.allLogsAsString)
    }
    private fun executeFFProbeLogCallback(logCallback: Function1<String, Unit>, log: com.arthenica.ffmpegkit.Log) {
        val message = log.message
        requireNotNull(message) { "getMessage(...)" }
        if (message.toDoubleOrNull() != null) {
            val message2 = log.message
            requireNotNull(message2) { "getMessage(...)" }
            logCallback.invoke(message2)
        }
    }
    override fun getFileExtension(): Pair<String, String> {
        return Pair("mkv", "video/x-matroska")

    }

    override fun getReadPath(context: Context, uri: Uri): String {
        val safParameterForRead = FFmpegKitConfig.getSafParameterForRead(context, uri)
        requireNotNull(safParameterForRead) { "getSafParameterForRead(...)" }
        return safParameterForRead
    }

    override fun getStackTrace(sessionId: Long): String {
        TODO("Not yet implemented")
    }

    override fun getState(sessionId: Long): String {
        TODO("Not yet implemented")
    }

    override fun hadError(sessionId: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun setDownloadPath(context: Context, uri: Uri): String {
        val safParameterForWrite = FFmpegKitConfig.getSafParameterForWrite(context, uri)
        requireNotNull(safParameterForWrite) { "getSafParameterForWrite(...)" }
        return safParameterForWrite
    }

}
