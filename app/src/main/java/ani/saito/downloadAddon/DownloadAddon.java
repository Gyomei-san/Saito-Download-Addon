package ani.saito.downloadAddon;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import ani.saito.addons.download.DownloadAddonApiV2;
import com.arthenica.ffmpegkit.FFmpegKit;
import com.arthenica.ffmpegkit.FFmpegKitConfig;
import com.arthenica.ffmpegkit.FFmpegSession;
import com.arthenica.ffmpegkit.FFprobeKit;
import com.arthenica.ffmpegkit.FFprobeSession;
import com.arthenica.ffmpegkit.FFprobeSessionCompleteCallback;
import com.arthenica.ffmpegkit.LogCallback;
import com.arthenica.ffmpegkit.SessionState;
import com.arthenica.ffmpegkit.Statistics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J;\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ;\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ}\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00142\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00160\u000b2\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00160\u000b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJA\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00142\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0016H\u0016J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010'\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lani/dantotsu/downloadAddon/DownloadAddon;", "Lani/dantotsu/addons/download/DownloadAddonApiV2;", "()V", "cancelDownload", "", "sessionId", "", "customFFMpeg", "command", "", "videoUrls", "", "logCallback", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customFFProbe", "executeFFMpeg", "videoUrl", "downloadPath", "headers", "", "subtitleUrls", "Lkotlin/Pair;", "audioUrls", "statCallback", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeFFProbe", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileExtension", "getReadPath", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "getStackTrace", "getState", "hadError", "", "setDownloadPath", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DownloadAddon.kt */
public final class DownloadAddon implements DownloadAddonApiV2 {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DownloadAddon.kt */
    /* compiled from: DownloadAddon.kt */
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[com.arthenica.ffmpegkit.SessionState.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[com.arthenica.ffmpegkit.SessionState.COMPLETED.ordinal()] = 1;
            r0[com.arthenica.ffmpegkit.SessionState.FAILED.ordinal()] = 2;
            r0[com.arthenica.ffmpegkit.SessionState.RUNNING.ordinal()] = 3;
        }
        private WhenMappings() {
            throw new UnsupportedOperationException("Method not decompiled: ani.satio.downloadAddon.DownloadAddon.WhenMappings.<clinit>():void");
        }
    }

    public void cancelDownload(long j) {
        FFmpegKit.cancel(j);
    }

    public String getReadPath(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String safParameterForRead = FFmpegKitConfig.getSafParameterForRead(context, uri);
        Intrinsics.checkNotNullExpressionValue(safParameterForRead, "getSafParameterForRead(...)");
        return safParameterForRead;
    }

    public String setDownloadPath(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String safParameterForWrite = FFmpegKitConfig.getSafParameterForWrite(context, uri);
        Intrinsics.checkNotNullExpressionValue(safParameterForWrite, "getSafParameterForWrite(...)");
        return safParameterForWrite;
    }

    public Pair<String, String> getFileExtension() {
        return new Pair<>("mkv", "video/x-matroska");
    }

    public Object executeFFProbe(String str, Map<String, String> map, Function1<? super String, Unit> function1, Continuation<? super Unit> continuation) {
        DownloadBuilder downloadBuilder = new DownloadBuilder();
        downloadBuilder.setVideoLink(str);
        downloadBuilder.setHeaders(map);
        FFprobeKit.executeAsync(downloadBuilder.buildProbe(), (FFprobeSessionCompleteCallback) new DownloadAddon$$ExternalSyntheticLambda6(), (LogCallback) new DownloadAddon$$ExternalSyntheticLambda7(function1));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void executeFFProbe$lambda$1(FFprobeSession fFprobeSession) {
        Log.d("FFmpegKit", fFprobeSession.getAllLogsAsString());
    }

    /* access modifiers changed from: private */
    public static final void executeFFProbe$lambda$2(Function1 function1, com.arthenica.ffmpegkit.Log log) {
        Intrinsics.checkNotNullParameter(function1, "$logCallback");
        String message = log.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        if (StringsKt.toDoubleOrNull(message) != null) {
            String message2 = log.getMessage();
            Intrinsics.checkNotNullExpressionValue(message2, "getMessage(...)");
            function1.invoke(message2);
        }
    }

    public Object executeFFMpeg(String str, String str2, Map<String, String> map, List<Pair<String, String>> list, List<Pair<String, String>> list2, Function1<? super Double, Unit> function1, Continuation<? super Long> continuation) {
        DownloadBuilder downloadBuilder = new DownloadBuilder();
        downloadBuilder.setDownloadPath(str2);
        downloadBuilder.setVideoLink(str);
        downloadBuilder.setHeaders(map);
        downloadBuilder.setSubtitleLinks(list);
        downloadBuilder.setAudioLinks(list2);
        return Boxing.boxLong(FFmpegKit.executeAsync(downloadBuilder.buildDownload(), new DownloadAddon$$ExternalSyntheticLambda0(), new DownloadAddon$$ExternalSyntheticLambda1(), new DownloadAddon$$ExternalSyntheticLambda2(function1)).getSessionId());
    }

    /* access modifiers changed from: private */
    public static final void executeFFMpeg$lambda$4(FFmpegSession fFmpegSession) {
        SessionState state = fFmpegSession.getState();
        Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
        Log.d("FFmpegKit", String.format("FFmpeg process exited with state %s and rc %s.%s", new Object[]{state, fFmpegSession.getReturnCode(), fFmpegSession.getFailStackTrace()}));
    }

    /* access modifiers changed from: private */
    public static final void executeFFMpeg$lambda$5(com.arthenica.ffmpegkit.Log log) {
        Log.d("FFmpegKit", log.getMessage());
    }

    /* access modifiers changed from: private */
    public static final void executeFFMpeg$lambda$6(Function1 function1, Statistics statistics) {
        Intrinsics.checkNotNullParameter(function1, "$statCallback");
        function1.invoke(Double.valueOf(statistics.getTime()));
        Log.d("FFmpegKit", "Statistics: " + statistics);
    }

    public Object customFFMpeg(String str, List<String> list, Function1<? super String, Unit> function1, Continuation<? super Long> continuation) {
        if (!Intrinsics.areEqual((Object) str, (Object) "1")) {
            return Boxing.boxLong(System.currentTimeMillis());
        }
        if (list.size() == 2) {
            return Boxing.boxLong(FFmpegKit.executeAsync("-i " + list.get(0) + " -codec copy -fflags +genpts " + list.get(1), new DownloadAddon$$ExternalSyntheticLambda3(), new DownloadAddon$$ExternalSyntheticLambda4(), new DownloadAddon$$ExternalSyntheticLambda5(function1)).getSessionId());
        }
        throw new RuntimeException("videoUrls is not 2");
    }

    /* access modifiers changed from: private */
    public static final void customFFMpeg$lambda$7(FFmpegSession fFmpegSession) {
        SessionState state = fFmpegSession.getState();
        Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
        Log.d("FFmpegKit", String.format("FFmpeg process exited with state %s and rc %s.%s", new Object[]{state, fFmpegSession.getReturnCode(), fFmpegSession.getFailStackTrace()}));
    }

    /* access modifiers changed from: private */
    public static final void customFFMpeg$lambda$8(com.arthenica.ffmpegkit.Log log) {
        Log.d("FFmpegKit", log.getMessage());
    }

    /* access modifiers changed from: private */
    public static final void customFFMpeg$lambda$9(Function1 function1, Statistics statistics) {
        Intrinsics.checkNotNullParameter(function1, "$logCallback");
        function1.invoke(String.valueOf(statistics.getTime()));
        Log.d("FFmpegKit", "Statistics: " + statistics);
    }

    public Object customFFProbe(String str, List<String> list, Function1<? super String, Unit> function1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public String getState(long j) {
        List<FFmpegSession> fFmpegSessions = FFmpegKitConfig.getFFmpegSessions();
        Intrinsics.checkNotNullExpressionValue(fFmpegSessions, "getFFmpegSessions(...)");
        for (FFmpegSession fFmpegSession : fFmpegSessions) {
            if (fFmpegSession.getSessionId() == j) {
                SessionState state = fFmpegSession.getState();
                int i = state == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i == 1) {
                    return "COMPLETED";
                }
                if (i == 2) {
                    return "FAILED";
                }
                if (i != 3) {
                    return "UNKNOWN";
                }
                return DebugCoroutineInfoImplKt.RUNNING;
            }
        }
        return "UNKNOWN";
    }

    public String getStackTrace(long j) {
        List<FFmpegSession> fFmpegSessions = FFmpegKitConfig.getFFmpegSessions();
        Intrinsics.checkNotNullExpressionValue(fFmpegSessions, "getFFmpegSessions(...)");
        for (FFmpegSession fFmpegSession : fFmpegSessions) {
            if (fFmpegSession.getSessionId() == j) {
                return fFmpegSession.getFailStackTrace();
            }
        }
        return null;
    }

    public boolean hadError(long j) {
        List<FFmpegSession> fFmpegSessions = FFmpegKitConfig.getFFmpegSessions();
        Intrinsics.checkNotNullExpressionValue(fFmpegSessions, "getFFmpegSessions(...)");
        for (FFmpegSession fFmpegSession : fFmpegSessions) {
            if (fFmpegSession.getSessionId() == j) {
                return fFmpegSession.getReturnCode().isValueError();
            }
        }
        return false;
    }
}