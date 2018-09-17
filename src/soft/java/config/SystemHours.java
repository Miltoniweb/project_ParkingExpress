
package soft.java.config;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SystemHours implements ActionListener{
    
    public void actionPerformed(ActionEvent e) {
       Date getHours = new Date();
       String workingDay = "hh:mm:ss a";
       SimpleDateFormat format = new SimpleDateFormat(workingDay);
        Calendar calendar = Calendar.getInstance();
        //   jLabel.setText(String.format(format.format(getHours), calendar));
    }
    
}
