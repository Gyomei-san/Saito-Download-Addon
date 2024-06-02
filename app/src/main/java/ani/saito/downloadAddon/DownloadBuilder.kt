package ani.saito.downloadAddon

import kotlin.collections.ArrayList
import kotlin.collections.Map
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.emptyList
import kotlin.text.StringBuilder

class DownloadBuilder {

    private var audioLinks: List<Pair<String, String>> = emptyList()
    private var downloadPath: String = ""
    private var headers: String = ""
    private var subtitleLinks: List<Pair<String, String>> = emptyList()
    private var videoLink: String = ""

    fun setHeaders(map: Map<String, String>): DownloadBuilder {
        require(map.isNotEmpty()) { "Headers cannot be empty" }

        val sb = StringBuilder()
        for ((key, value) in map) {
            sb.append("\"$key: $value\"\r\n")
        }
        headers = sb.toString()
        return this
    }

    fun setAudioLinks(list: List<Pair<String, String>>): DownloadBuilder {
        val filteredList = list.filter {
            it.first != videoLink && it.first.isNotEmpty()
        }
        audioLinks = filteredList
        return this
    }

    fun setSubtitleLinks(list: List<Pair<String, String>>): DownloadBuilder {
        val filteredList = list.filter {
            it.first != videoLink && it.first.isNotEmpty()
        }
        subtitleLinks = filteredList
        return this
    }

    fun setVideoLink(str: String): DownloadBuilder {
        require(str.isNotEmpty()) { "Video link cannot be empty" }
        videoLink = str
        return this
    }

    fun setDownloadPath(str: String): DownloadBuilder {
        require(str.isNotEmpty()) { "Download path cannot be empty" }
        downloadPath = str
        return this
    }

    fun buildDownload(): String {
        require(downloadPath.isNotEmpty() && videoLink.isNotEmpty()) { "Download path and video link cannot be empty" }

        val sb = StringBuilder()
        if (headers.isNotEmpty()) {
            sb.append("-headers $headers ")
        }
        sb.append("-fflags +discardcorrupt -err_detect ignore_err -reconnect 1 -reconnect_streamed 1 -reconnect_on_network_error 1 -reconnect_on_http_error 1 -reconnect_delay_max 600 -tls_verify 0 ")

        val isPlaylist = videoLink.contains(".m3u", ignoreCase = true) || videoLink.contains(".mpd", ignoreCase = true)
        if (isPlaylist) {
            sb.append("-max_reload 1000 -seg_max_retry 1000 -m3u8_hold_counters 10000 ")
        }
        sb.append("-i \"$videoLink\" ")

        audioLinks.forEach {
            sb.append("-i \"${it.first}\" ")
        }

        subtitleLinks.forEach {
            sb.append("-i \"${it.first}\" ")
        }

        sb.append("-bufsize 1024k -map 0:v -c:v copy -map 0:a? -c:a copy -map 0:s? ")

        audioLinks.forEachIndexed { index, pair ->
            sb.append("-map ${index + 1}:a ")
            if (pair.second.isNotEmpty()) {
                sb.append("-metadata:s:a:$index language=${pair.second} ")
            }
        }

        subtitleLinks.forEachIndexed { index, pair ->
            sb.append("-map ${audioLinks.size + index + 1}:s ")
            if (pair.second.isNotEmpty()) {
                sb.append("-metadata:s:s:$index language=${pair.second} ")
                sb.append("-metadata:s:s:$index title=${pair.second} ")
            }
        }

        sb.append("-c:s srt -f matroska ")
        sb.append("$downloadPath -v trace")
        return sb.toString()
    }

    fun buildProbe(): String {
        require(videoLink.isNotEmpty()) { "Video link cannot be empty" }

        val sb = StringBuilder()
        if (headers.isNotEmpty()) {
            sb.append("-headers $headers")
        }
        sb.append(" -i \"$videoLink\"")
        sb.append(" -show_entries format=duration -v quiet -of csv=\"p=0\"")
        return sb.toString()
    }
}
