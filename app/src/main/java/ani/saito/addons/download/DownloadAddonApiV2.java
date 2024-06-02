package ani.saito.addons.download;

import android.content.Context;
import android.net.Uri;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J;\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ;\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0001\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00132\u001a\b\u0002\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00150\n2\u001a\b\u0002\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00150\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00030\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019JC\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\b2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0015H\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H&J\u0012\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010&\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H&\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lani/dantotsu/addons/download/DownloadAddonApiV2;", "", "cancelDownload", "", "sessionId", "", "customFFMpeg", "command", "", "videoUrls", "", "logCallback", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customFFProbe", "executeFFMpeg", "videoUrl", "downloadPath", "headers", "", "subtitleUrls", "Lkotlin/Pair;", "audioUrls", "statCallback", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeFFProbe", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileExtension", "getReadPath", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "getStackTrace", "getState", "hadError", "", "setDownloadPath", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DownloadAddonApiV2.kt */
public interface DownloadAddonApiV2 {
    void cancelDownload(long j);

    Object customFFMpeg(String str, List<String> list, Function1<? super String, Unit> function1, Continuation<? super Long> continuation);

    Object customFFProbe(String str, List<String> list, Function1<? super String, Unit> function1, Continuation<? super Unit> continuation);

    Object executeFFMpeg(String str, String str2, Map<String, String> map, List<Pair<String, String>> list, List<Pair<String, String>> list2, Function1<? super Double, Unit> function1, Continuation<? super Long> continuation);

    Object executeFFProbe(String str, Map<String, String> map, Function1<? super String, Unit> function1, Continuation<? super Unit> continuation);

    Pair<String, String> getFileExtension();

    String getReadPath(Context context, Uri uri);

    String getStackTrace(long j);

    String getState(long j);

    boolean hadError(long j);

    String setDownloadPath(Context context, Uri uri);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DownloadAddonApiV2.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object executeFFProbe$default(DownloadAddonApiV2 downloadAddonApiV2, String str, Map map, Function1 function1, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = MapsKt.emptyMap();
                }
                return downloadAddonApiV2.executeFFProbe(str, map, function1, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeFFProbe");
        }

        public static /* synthetic */ Object executeFFMpeg$default(DownloadAddonApiV2 downloadAddonApiV2, String str, String str2, Map map, List list, List list2, Function1 function1, Continuation continuation, int i, Object obj) {
            List list3;
            if (obj == null) {
                Map emptyMap = (i & 4) != 0 ? MapsKt.emptyMap() : map;
                List emptyList = (i & 8) != 0 ? CollectionsKt.emptyList() : list;
                if ((i & 16) != 0) {
                    list3 = CollectionsKt.emptyList();
                } else {
                    list3 = list2;
                }
                return downloadAddonApiV2.executeFFMpeg(str, str2, emptyMap, emptyList, list3, function1, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeFFMpeg");
        }

        public static Pair<String, String> getFileExtension(DownloadAddonApiV2 downloadAddonApiV2) {
            return new Pair<>("mkv", "video/x-matroska");
        }
    }
}
