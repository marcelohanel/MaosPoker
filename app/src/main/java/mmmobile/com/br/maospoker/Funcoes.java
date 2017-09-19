package mmmobile.com.br.maospoker;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;

import com.google.android.gms.ads.AdRequest;

class Funcoes {

    static AdRequest adRequest;

    static String getVersionName(Context context) {
        try {
            ComponentName comp = new ComponentName(context, context.getClass());
            PackageInfo pinfo = context.getPackageManager().getPackageInfo(comp.getPackageName(), 0);
            return pinfo.versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            return null;
        }
    }
}
