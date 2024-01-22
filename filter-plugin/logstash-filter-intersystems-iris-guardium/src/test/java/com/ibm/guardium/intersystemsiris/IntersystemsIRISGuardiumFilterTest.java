/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.ibm.guardium.intersystemsiris;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.logstash.plugins.ContextImpl;

import com.ibm.guardium.universalconnector.commons.GuardConstants;

import co.elastic.logstash.api.Context;
import co.elastic.logstash.api.Event;
import co.elastic.logstash.api.FilterMatchListener;

public class IntersystemsIRISGuardiumFilterTest {
	final static Context context = new ContextImpl(null, null);
	final static IntersystemsIRISGuardiumFilter filter = new IntersystemsIRISGuardiumFilter("test-id", null, context);

	@Test
	public void testIris_CreateTable() {
		final String message = "{\"@timestamp\":\"2023-06-08T07:23:04.607Z\",\"systemid\":\"ip-172-31-91-96:IRIS\",\"@version\":\"1\",\"namespace\":\"%SYS\",\"clientipaddress\":null,\"username\":\"guardium_dev\",\"eventdata\":\"/* user */CREATE TABLE Soumalya(age INT)/*#OPTIONS {\\\"xDBC\\\":1} */\",\"event\":\"XDBCStatement\",\"mytimestamp\":\"2023-06-08 07:25:01.250\",\"type\":\"test\",\"osusername\":\"vaishnavi.g\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
	
	@Test
	public void testIris_DeleteUser() {
		final String message = "{\"@timestamp\":\"2023-06-08T07:23:04.607Z\",\"systemid\":\"ip-172-31-91-96:IRIS\",\"@version\":\"1\",\"namespace\":\"%SYS\",\"clientipaddress\":null,\"username\":\"guardium_dev\",\"eventdata\":null,\"event\":\"UserChange\",\"mytimestamp\":\"2023-06-08 07:25:01.250\",\"description\":\"Delete USER apamb1\",\"type\":\"test\",\"osusername\":\"vaishnavi.g\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
		
	@Test
	public void testIris_CreateUser() {
		final String message = "{\"@timestamp\":\"2023-06-08T07:23:04.607Z\",\"systemid\":\"ip-172-31-91-96:IRIS\",\"@version\":\"1\",\"namespace\":\"%SYS\",\"clientipaddress\":null,\"username\":\"guardium_dev\",\"eventdata\":\"Create User: apamb1 AccountNeverExpires: No Attributes: Comment: EmailAddress: xyz Enabled: Yes ExpirationDate: 2021-02-02 Full Name: new user NameSpace: %SYS Password: ***** Password Hash AlgorithSHA512 Password Hash Work Fac10000 PasswordNeverExpires: No PhoneNumber: 4335353 PhoneProvider: AutheEnabled: Roles: Routine: \",\"event\":\"UserChange\",\"mytimestamp\":\"2023-06-08 07:25:01.250\",\"description\":\"Create USER apamb1\",\"type\":\"test\",\"osusername\":\"vaishnavi.g\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
	
	@Test
	public void testIris_Select() {
		final String message = "{\"eventdata\":\" SELECT * FROM demotable4\\r\\n /*#OPTIONS { \\\"IsolationLevel\\\":0 } */\",\"event\":\"DynamicStatement\",\"type\":\"test\",\"osusername\":\"CSP Gateway\",\"namespace\":\"IRISDB2605\",\"mytimestamp\":\"2023-07-04 05:45:37.822\",\"@timestamp\":\"2023-07-04T05:45:11.664Z\",\"systemid\":\"ip-172-31-33-219:IRIS\",\"clientipaddress\":null,\"username\":\"UnknownUser\",\"@version\":\"1\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
	
	@Test
	public void testIris_Nested_Select() {
		final String message = "{\"eventdata\":\"SELECT Name,Salary,Home_State FROM Sample.Employee WHERE Salary > 75000 AND Home_State = ANY (SELECT State FROM Sample.USZipCode  WHERE Longitude < -93) ORDER BY Home_State\",\"event\":\"DynamicStatement\",\"type\":\"test\",\"osusername\":\"CSP Gateway\",\"namespace\":\"IRISDB2605\",\"mytimestamp\":\"2023-07-04 05:45:37.822\",\"@timestamp\":\"2023-07-04T05:45:11.664Z\",\"systemid\":\"ip-172-31-33-219:IRIS\",\"clientipaddress\":null,\"username\":\"UnknownUser\",\"@version\":\"1\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
	
	@Test
	public void testIris_Delete() {
		final String message = "{\"eventdata\":\" DELETE FROM Employee1 WHERE EmpNum = ? /*#OPTIONS {\\\"DynamicSQLTypeList\\\":\\\"10\\\"} */\\r\\n /*#OPTIONS { \\\"IsolationLevel\\\":0 } */\\r\\nParameter values:\\r\\n%CallArgs(1)=12\",\"event\":\"DynamicStatement\",\"type\":\"test\",\"osusername\":\"CSP Gateway\",\"namespace\":\"IRISDB2605\",\"mytimestamp\":\"2023-07-04 05:54:37.940\",\"@timestamp\":\"2023-07-04T05:54:06.877Z\",\"systemid\":\"ip-172-31-33-219:IRIS\",\"clientipaddress\":null,\"username\":\"UnknownUser\",\"@version\":\"1\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}

	@Test
	public void testIris_InsertTable() {
		final String message = "{\"@version\":\"1\",\"osusername\":\"CSP Gateway\",\"event\":\"DynamicStatement\",\"namespace\":\"%SYS\",\"clientipaddress\":\"20.204.110.141\",\"@timestamp\":\"2023-06-08T10:35:06.410Z\",\"systemid\":\"ip-172-31-91-96:IRIS\",\"username\":\"UnknownUser\",\"mytimestamp\":\"2023-06-08 10:07:53.452\",\"eventdata\":\" INSERT INTO samples1 VALUES ( ? , ? , ? ) /*#OPTIONS {\\\"DynamicSQLTypeList\\\":\\\"10,1,1\\\"} */\\r\\n /*#OPTIONS { \\\"IsolationLevel\\\":0 } */\\r\\nParameter values:\\r\\n%CallArgs(1)=1\\r\\n%CallArgs(2)=\\\"Vaishu\\\"\\r\\n%CallArgs(3)=\\\"Gopi\\\"\",\"type\":\"test\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}

	@Test
	public void testIris_Drop() {
		final String message = "{\"osusername\":\"CSP Gateway\",\"@timestamp\":\"2023-06-29T08:11:07.314Z\",\"mytimestamp\":\"2023-06-29 08:09:13.953\",\"username\":\"UnknownUser\",\"namespace\":\"IRISDB2605\",\"type\":\"test\",\"eventdata\":\" \\r\\nDROP TABLE soumalya\",\"@version\":\"1\",\"clientipaddress\":\"20.204.110.141\",\"event\":\"DynamicStatement\",\"systemid\":\"ip-172-31-33-219:IRIS\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
	
	@Test
	public void testIris_Truncate() {
		final String message = "{\"eventdata\":\" TRUNCATE TABLE Employee1\\r\\n /*#OPTIONS { \\\"IsolationLevel\\\":0 } */\",\"event\":\"DynamicStatement\",\"type\":\"test\",\"osusername\":\"CSP Gateway\",\"namespace\":\"IRISDB2605\",\"mytimestamp\":\"2023-07-04 05:57:28.458\",\"@timestamp\":\"2023-07-04T05:57:05.222Z\",\"systemid\":\"ip-172-31-33-219:IRIS\",\"clientipaddress\":null,\"username\":\"UnknownUser\",\"@version\":\"1\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
	
	@Test
	public void testIris_CreateProcedure() {
		final String message ="{\"eventdata\":\" \\r\\nCREATE PROCEDURE RandomLetterSP() \\r\\nRETURNS INTEGER \\r\\nLANGUAGE OBJECTSCRIPT \\r\\n{ \\r\\n:Top \\r\\nSET x=$RANDOM(90) \\r\\nIF x<65 {GOTO Top} \\r\\nELSE {QUIT $CHAR(x)} \\r\\n}\",\"event\":\"DynamicStatement\",\"type\":\"test\",\"osusername\":\"CSP Gateway\",\"namespace\":\"%SYS\",\"mytimestamp\":\"2023-07-04 06:32:25.931\",\"@timestamp\":\"2023-07-04T06:32:02.378Z\",\"systemid\":\"ip-172-31-33-219:IRIS\",\"clientipaddress\":null,\"username\":\"UnknownUser\",\"@version\":\"1\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
	
	@Test
	public void testIris_NoDb() {
		final String message = "{\"osusername\":\"CSP Gateway\",\"@timestamp\":\"2023-06-29T08:11:07.314Z\",\"mytimestamp\":\"2023-06-29 08:09:13.953\",\"username\":\"UnknownUser\",\"type\":\"test\",\"eventdata\":\" \\r\\nDROP TABLE soumalya\",\"@version\":\"1\",\"clientipaddress\":\"20.204.110.141\",\"event\":\"DynamicStatement\",\"systemid\":\"ip-172-31-33-219:IRIS\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}

	@Test
	public void testIris_UPDATE() {
		final String message = "{\"clientipaddress\":\"20.204.110.141\",\"event\":\"DynamicStatement\",\"@timestamp\":\"2023-06-29T08:32:07.068Z\",\"mytimestamp\":\"2023-06-29 08:29:59.104\",\"username\":\"UnknownUser\",\"eventdata\":\" UPDATE soumalya SET FirstName = ? WHERE ID = ? /*#OPTIONS {\\\"DynamicSQLTypeList\\\":\\\"1,10\\\"} */\\r\\n /*#OPTIONS { \\\"IsolationLevel\\\":0 } */\\r\\nParameter values:\\r\\n%CallArgs(1)=\\\"Nitin\\\"\\r\\n%CallArgs(2)=1\",\"type\":\"test\",\"systemid\":\"ip-172-31-33-219:IRIS\",\"namespace\":\"IRISDB2605\",\"@version\":\"1\",\"osusername\":\"CSP Gateway\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}

	@Test
	public void testMysql_NoMessage() {
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
	}

	@Test
	public void testMysql_Empty() throws Exception {
		final String message = "";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
	}

	@Test
	public void testIris_IPV6() {
		final String message = "{\"@version\":\"1\",\"osusername\":\"CSP Gateway\",\"event\":\"DynamicStatement\",\"namespace\":\"%SYS\",\"clientipaddress\":\"2001:0db8:85a3:0000:0000:8a2e:0370:7334\",\"@timestamp\":\"2023-06-08T10:35:06.410Z\",\"systemid\":\"ip-172-31-91-96:IRIS\",\"username\":\"UnknownUser\",\"mytimestamp\":\"2023-06-08 10:07:53.452\",\"eventdata\":\" INSERT INTO samples1 VALUES ( ? , ? , ? ) /*#OPTIONS {\\\"DynamicSQLTypeList\\\":\\\"10,1,1\\\"} */\\r\\n /*#OPTIONS { \\\"IsolationLevel\\\":0 } */\\r\\nParameter values:\\r\\n%CallArgs(1)=1\\r\\n%CallArgs(2)=\\\"Vaishu\\\"\\r\\n%CallArgs(3)=\\\"Gopi\\\"\",\"type\":\"test\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
	
	@Test
	public void testIris_NullClientIP() {
		final String message = "{\"@version\":\"1\",\"osusername\":\"CSP Gateway\",\"event\":\"DynamicStatement\",\"namespace\":\"%SYS\",\"clientipaddress\":null,\"@timestamp\":\"2023-06-08T10:35:06.410Z\",\"systemid\":\"ip-172-31-91-96:IRIS\",\"username\":\"UnknownUser\",\"mytimestamp\":\"2023-06-08 10:07:53.452\",\"eventdata\":\" INSERT INTO samples1 VALUES ( ? , ? , ? ) /*#OPTIONS {\\\"DynamicSQLTypeList\\\":\\\"10,1,1\\\"} */\\r\\n /*#OPTIONS { \\\"IsolationLevel\\\":0 } */\\r\\nParameter values:\\r\\n%CallArgs(1)=1\\r\\n%CallArgs(2)=\\\"Vaishu\\\"\\r\\n%CallArgs(3)=\\\"Gopi\\\"\",\"type\":\"test\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
	
	@Test
	public void testIris_NullServerIP() {
		final String message = "{\"@version\":\"1\",\"osusername\":\"CSP Gateway\",\"event\":\"DynamicStatement\",\"namespace\":\"%SYS\",\"clientipaddress\":\"20.204.110.141\",\"serveripaddress\":null,\"@timestamp\":\"2023-06-08T10:35:06.410Z\",\"systemid\":\"ip-172-31-91-96:IRIS\",\"username\":\"UnknownUser\",\"mytimestamp\":\"2023-06-08 10:07:53.452\",\"eventdata\":\" INSERT INTO samples1 VALUES ( ? , ? , ? ) /*#OPTIONS {\\\"DynamicSQLTypeList\\\":\\\"10,1,1\\\"} */\\r\\n /*#OPTIONS { \\\"IsolationLevel\\\":0 } */\\r\\nParameter values:\\r\\n%CallArgs(1)=1\\r\\n%CallArgs(2)=\\\"Vaishu\\\"\\r\\n%CallArgs(3)=\\\"Gopi\\\"\",\"type\":\"test\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}
	
	@Test
	public void testIris_NoIP() {
		final String message = "{\"@version\":\"1\",\"osusername\":\"CSP Gateway\",\"event\":\"DynamicStatement\",\"namespace\":\"%SYS\",\"@timestamp\":\"2023-06-08T10:35:06.410Z\",\"systemid\":\"ip-172-31-91-96:IRIS\",\"username\":\"UnknownUser\",\"mytimestamp\":\"2023-06-08 10:07:53.452\",\"eventdata\":\" INSERT INTO samples1 VALUES ( ? , ? , ? ) /*#OPTIONS {\\\"DynamicSQLTypeList\\\":\\\"10,1,1\\\"} */\\r\\n /*#OPTIONS { \\\"IsolationLevel\\\":0 } */\\r\\nParameter values:\\r\\n%CallArgs(1)=1\\r\\n%CallArgs(2)=\\\"Vaishu\\\"\\r\\n%CallArgs(3)=\\\"Gopi\\\"\",\"type\":\"test\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}

	@Test
	public void testIris_LoginFailed() {
		final String message = "{\"@version\":\"1\",\"osusername\":\"CSP Gateway\",\"event\":\"LoginFailure\",\"namespace\":\"%SYS\",\"clientipaddress\":\"103.149.70.62\",\"@timestamp\":\"2023-06-08T10:39:02.992Z\",\"systemid\":\"ip-172-31-91-96:IRIS\",\"username\":\"guardium_dev\",\"mytimestamp\":\"2023-06-08 10:41:11.842\",\"eventdata\":\"Error message: ERROR #798: Password login failed\\r\\nERROR #952: Invalid password\\r\\nWeb Application:/csp/sys\\r\\n$I:|TCP|1972|1689\\r\\n$P:|TCP|1972|1689\\r\\n\",\"type\":\"test\"}";
		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField("message", message);
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);
		assertEquals(1, results.size());
		assertNotNull(e.getField(GuardConstants.GUARDIUM_RECORD_FIELD_NAME));
		assertEquals(1, matchListener.getMatchCount());
	}

	@Test
	public void getIdTest() {
		final String mysqlString = "";
		Event e = new org.logstash.Event();
		e.setField("message", mysqlString);
		String id = filter.getId();
	}
}

class TestMatchListener implements FilterMatchListener {
	private AtomicInteger matchCount = new AtomicInteger(0);

	public int getMatchCount() {
		return matchCount.get();
	}

	@Override
	public void filterMatched(co.elastic.logstash.api.Event arg0) {
		matchCount.incrementAndGet();

	}
}
