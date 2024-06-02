package ani.saito.addons.download

import android.content.Context
import android.net.Uri
import kotlin.collections.emptyList
import kotlin.collections.emptyMap
import kotlin.coroutines.Continuation
import kotlin.jvm.functions.Function1

interface DownloadAddonApiV2 {

    fun cancelDownload(sessionId: Long)

    suspend fun customFFMpeg(command: String, videoUrls: List<String>, logCallback: Function1<String, Unit>): Long

    suspend fun customFFProbe(command: String, videoUrls: List<String>, logCallback: Function1<String, Unit>)

    suspend fun executeFFMpeg(
        videoUrl: String,
        downloadPath: String,
        headers: Map<String, String>,
        subtitleUrls: List<Pair<String, String>>,
        audioUrls: List<Pair<String, String>>,
        statCallback: (Double) -> Unit,
        continuation: Continuation<Long>
    ): Long

    suspend fun executeFFProbe(
        command: String,
        videoUrls: Map<String, String>,
        logCallback: Function1<String, Unit>,
        continuation: Continuation<Unit>
    )

    fun getFileExtension(): Pair<String, String>

    fun getReadPath(context: Context, uri: Uri): String

    fun getStackTrace(sessionId: Long): String

    fun getState(sessionId: Long): String

    fun hadError(sessionId: Long): Boolean

    fun setDownloadPath(context: Context, uri: Uri): String

    companion object DefaultImpls {
        suspend fun DownloadAddonApiV2.executeFFProbe(
            command: String,
            videoUrls: Map<String, String>,
            logCallback: Function1<String, Unit>,
            continuation: Continuation<Unit>
        ) = executeFFProbe(command, videoUrls, logCallback, continuation)

        suspend fun DownloadAddonApiV2.executeFFMpeg(
            videoUrl: String,
            downloadPath: String,
            headers: Map<String, String>,
            subtitleUrls: List<Pair<String, String>>,
            audioUrls: List<Pair<String, String>>,
            statCallback: (Double) -> Unit,
            continuation: Continuation<Long>
        ) = executeFFMpeg(videoUrl, downloadPath, headers, subtitleUrls, audioUrls, statCallback, continuation)

        fun DownloadAddonApiV2.getFileExtension() = Pair("mkv", "video/x-matroska")
    }
}
