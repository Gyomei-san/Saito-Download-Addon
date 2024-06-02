package ani.saito.downloadAddon;

import com.arthenica.ffmpegkit.Statistics;
import com.arthenica.ffmpegkit.StatisticsCallback;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DownloadAddon$$ExternalSyntheticLambda5 implements StatisticsCallback {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ DownloadAddon$$ExternalSyntheticLambda5(Function1 function1) {
        this.f$0 = function1;
    }

    public final void apply(Statistics statistics) {
        DownloadAddon.customFFMpeg$lambda$9(this.f$0, statistics);
    }
}