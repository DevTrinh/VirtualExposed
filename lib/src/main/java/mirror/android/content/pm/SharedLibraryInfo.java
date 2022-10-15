package mirror.android.content.pm;

import android.content.pm.VersionedPackage;
import android.os.Build;

import java.util.List;

import mirror.MethodParams;
import mirror.RefClass;
import mirror.RefConstructor;


/**
 * @author LittleAngry
 */
public class SharedLibraryInfo {
    public static Class<?> TYPE = RefClass.load(SharedLibraryInfo.class, "android.content.pm.SharedLibraryInfo");
    @MethodParams({String.class, String.class, List.class,
            String.class, long.class, int.class,
            VersionedPackage.class, List.class,
            List.class, boolean.class})
    public static RefConstructor constructorS;

    @MethodParams({String.class, String.class, List.class,
            String.class, long.class, int.class,
            VersionedPackage.class, List.class,
            List.class})
    public static RefConstructor constructor;


    public static android.content.pm.SharedLibraryInfo createSharedLibInfo(String path, String packageName, List<String> codePaths,
                                                                           String name, long version, int type,
                                                                           VersionedPackage declaringPackage, List<VersionedPackage> dependentPackages,
                                                                           List<SharedLibraryInfo> dependencies, boolean isNative) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
            return (android.content.pm.SharedLibraryInfo) mirror.android.content.pm.SharedLibraryInfo.constructorS.newInstance(path, packageName, codePaths, name, version, type, declaringPackage, dependentPackages, dependencies, isNative);

        return (android.content.pm.SharedLibraryInfo) mirror.android.content.pm.SharedLibraryInfo.constructor.newInstance(path, packageName, codePaths, name, version, type, declaringPackage, dependentPackages, dependencies);
    }
}
