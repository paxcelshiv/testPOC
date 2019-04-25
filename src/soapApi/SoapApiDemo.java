package soapApi;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class SoapApiDemo {
	public static void runScript() throws XmlException, IOException, SoapUIException {
		WsdlProject project=new WsdlProject("C:\\Users\\g522830\\Documents\\NumberConversion-soapui-project.xml");
		WsdlTestSuite suite=project.getTestSuiteByName("TestSuite12");
		System.out.println("***********Test cases goint execuite......***************");
		for(int i=0;i<suite.getTestCaseCount();i++) {
			System.out.println("--------------------Test case:"+i+"----------------------");
			WsdlTestCase testCase=suite.getTestCaseAt(i);
			TestRunner runner=testCase.run(new PropertiesMap(), false);
			//System.out.println(Status.FINISHED+"\n"+runner.getStatus());
			Assert.assertEquals(Status.FINISHED.toString(), runner.getStatus().toString());
		}
	}

	public static void main(String[] args) throws XmlException, IOException, SoapUIException {
		runScript();
		// TODO Auto-generated method stub

	}

}
