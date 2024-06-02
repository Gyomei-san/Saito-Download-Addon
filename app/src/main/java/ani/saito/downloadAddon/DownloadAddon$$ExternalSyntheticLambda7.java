package ani.saito.downloadAddon;

import com.arthenica.ffmpegkit.Log;
import com.arthenica.ffmpegkit.LogCallback;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DownloadAddon$$ExternalSyntheticLambda7 implements LogCallback {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ DownloadAddon$$ExternalSyntheticLambda7(Function1 function1) {
        this.f$0 = function1;
    }

    public final void apply(Log log) {
        DownloadAddon.executeFFProbe$lambda$2(this.f$0, log);
    }
}