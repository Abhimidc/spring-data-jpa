package spring_data_jpa_example.spring_data_jpa_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idc.homedoctor.config.AppConfig;
import com.idc.homedoctor.model.Account;
import com.idc.homedoctor.service.AccountService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        AccountService obj=context.getBean(AccountService.class);
      obj.transfer();
   //Account acc2=obj.findWithPK(890);
        
       
     // System.out.println(acc2);
    }
}
