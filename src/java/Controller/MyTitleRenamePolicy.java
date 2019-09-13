
package Controller;

import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.File;
import java.util.Calendar;


public class MyTitleRenamePolicy implements FileRenamePolicy {

    Calendar currentDate = Calendar.getInstance();

    @Override
    public File rename(File file) {

        return new File(file.getParentFile(), "" + currentDate.getTimeInMillis() + "" + file.getName().substring(file.getName().lastIndexOf(".")));

    }

}
