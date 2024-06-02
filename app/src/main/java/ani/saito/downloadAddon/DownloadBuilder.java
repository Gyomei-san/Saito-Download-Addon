package ani.saito.downloadAddon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J \u0010\r\u001a\u00020\u00002\u0018\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010\u000f\u001a\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010J \u0010\u0011\u001a\u00020\u00002\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lani/dantotsu/downloadAddon/DownloadBuilder;", "", "()V", "audioLinks", "", "Lkotlin/Pair;", "", "downloadPath", "headers", "subtitleLinks", "videoLink", "buildDownload", "buildProbe", "setAudioLinks", "setDownloadPath", "setHeaders", "", "setSubtitleLinks", "setVideoLink", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DownloadBuilder.kt */
public final class DownloadBuilder {
    private List<Pair<String, String>> audioLinks = CollectionsKt.emptyList();
    private String downloadPath = "";
    private String headers = "";
    private List<Pair<String, String>> subtitleLinks = CollectionsKt.emptyList();
    private String videoLink = "";

    public final DownloadBuilder setHeaders(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "headers");
        if (!map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : map.entrySet()) {
                sb.append("\"" + ((String) next.getKey()) + ": " + ((String) next.getValue()) + "\"'\r\n'");
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            this.headers = sb2;
            return this;
        }
        throw new IllegalArgumentException("Headers cannot be empty");
    }

    public final DownloadBuilder setAudioLinks(List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "audioLinks");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            Pair pair = (Pair) next;
            if (!Intrinsics.areEqual(pair.getFirst(), (Object) this.videoLink) && ((CharSequence) pair.getFirst()).length() > 0) {
                arrayList.add(next);
            }
        }
        this.audioLinks = (List) arrayList;
        return this;
    }

    public final DownloadBuilder setSubtitleLinks(List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "subtitleLinks");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            Pair pair = (Pair) next;
            if (!Intrinsics.areEqual(pair.getFirst(), (Object) this.videoLink) && ((CharSequence) pair.getFirst()).length() > 0) {
                arrayList.add(next);
            }
        }
        this.subtitleLinks = (List) arrayList;
        return this;
    }

    public final DownloadBuilder setVideoLink(String str) {
        Intrinsics.checkNotNullParameter(str, "videoLink");
        if (str.length() != 0) {
            this.videoLink = str;
            return this;
        }
        throw new IllegalArgumentException("Video link cannot be empty");
    }

    public final DownloadBuilder setDownloadPath(String str) {
        Intrinsics.checkNotNullParameter(str, "downloadPath");
        if (str.length() != 0) {
            this.downloadPath = str;
            return this;
        }
        throw new IllegalArgumentException("Download path cannot be empty");
    }

    public final String buildDownload() {
        if (this.downloadPath.length() == 0 || this.videoLink.length() == 0) {
            throw new IllegalArgumentException("Download path and video link cannot be empty");
        }
        int i = 0;
        boolean z = StringsKt.contains((CharSequence) this.videoLink, (CharSequence) ".m3u", false) || StringsKt.contains((CharSequence) this.videoLink, (CharSequence) ".mpd", false);
        StringBuilder sb = new StringBuilder();
        if (this.headers.length() > 0) {
            sb.append("-headers " + this.headers + ' ');
        }
        sb.append("-fflags +discardcorrupt -err_detect ignore_err -reconnect 1 -reconnect_streamed 1 -reconnect_on_network_error 1 -reconnect_on_http_error 1 -reconnect_delay_max 600 -tls_verify 0 ");
        if (z) {
            sb.append("-max_reload 1000 -seg_max_retry 1000 -m3u8_hold_counters 10000 ");
        }
        sb.append("-i \"" + this.videoLink + "\" ");
        for (Pair first : this.audioLinks) {
            sb.append("-i \"" + ((String) first.getFirst()) + "\" ");
        }
        int i2 = 0;
        for (Object next : this.subtitleLinks) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sb.append("-i \"" + ((String) ((Pair) next).getFirst()) + "\" ");
            i2 = i3;
        }
        sb.append("-bufsize 1024k -map 0:v -c:v copy -map 0:a? -c:a copy -map 0:s? ");
        int i4 = 0;
        for (Object next2 : this.audioLinks) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) next2;
            sb.append("-map " + i5 + ":a ");
            if (((CharSequence) pair.getSecond()).length() > 0) {
                sb.append("-metadata:s:a:" + i4 + " language=" + ((String) pair.getSecond()) + ' ');
            }
            i4 = i5;
        }
        int i6 = 0;
        for (Object next3 : this.subtitleLinks) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair2 = (Pair) next3;
            sb.append("-map " + (i + this.audioLinks.size() + i7) + ":s -c:s mov_text ");
            if (((CharSequence) pair2.getSecond()).length() > 0) {
                sb.append("-metadata:s:s:" + i6 + " language=" + ((String) pair2.getSecond()) + ' ');
            }
            i6 = i7;
        }
        sb.append(this.downloadPath);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String buildProbe() {
        String str = this.videoLink;
        Intrinsics.checkNotNullExpressionValue(str, "videoLink");
        return "-probesize 10M -analyzeduration 10M -fflags +discardcorrupt -err_detect ignore_err -reconnect 1 -reconnect_streamed 1 -reconnect_on_network_error 1 -reconnect_on_http_error 1 -reconnect_delay_max 600 -tls_verify 0 -i \"" + str + "\" -print_format json -show_format -show_streams";
    }
}
