package utilities;

import org.testng.annotations.DataProvider;
import config.ProjectSettings;

public class TestDataProviders {

	final static int a = 5;

	// @formatter:off
	// Data provider used to provide login credentials
	@DataProvider(name = "LoginCredentials", indices = { a })
	public static Object[][] credentials() throws Exception {

		return XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "Login");

	}

	// @DataProvider(name="Demo")
	// public static Object[][] dp() throws Exception {
	// List<Object[]> result = Lists.newArrayList();
	// result.addAll(Arrays.asList(credentials()));
	//
	// result.addAll(Arrays.asList(PatientTagsData()));
	// System.out.println(result.size());
	// return result.toArray(new Object[result.size()][]);
	// }

	// ---------------------------------------------------

	// @DataProvider(name = "ColorCodes")
	// public static Object[][] geColorCodes() {
	// return new Object[][] {new Object[] {ProjectSettings.baseURL},new Object[]
	// {ProjectSettings.userName },
	// new Object[] { ProjectSettings.password }
	// };
	// }
	//

	// ------------------------------------------------------------------

	// @DataProvider(name = "Demo")
	// public static Object[][] getObjectCodes() throws Exception{
	// return combine(credentials(), PatientTagsData());
	// }
	//
	//
	// /**
	// * Returns the list of combination of color and shape codes.
	// *
	// * @return the collection of combined color and shape codes.
	// */
	// public static Object[][] combine(Object[][] a1, Object[][] a2){
	// List<Object[]> objectCodesList = new LinkedList<Object[]>();
	// for(Object[] o : a1){
	// for(Object[] o2 : a2){
	// objectCodesList.add(concatAll(o, o2));
	// }
	// }
	// return objectCodesList.toArray(new Object[0][0]);
	// }
	//
	//
	// @SafeVarargs
	// public static <T> T[] concatAll(T[] first, T[]... rest) {
	// //calculate the total length of the final object array after the concat
	// int totalLength = first.length;
	// for (T[] array : rest) {
	// totalLength += array.length;
	// }
	// //copy the first array to result array and then copy each array completely to
	// result
	// T[] result = Arrays.copyOf(first, totalLength);
	// int offset = first.length;
	// for (T[] array : rest) {
	// System.arraycopy(array, 0, result, offset, array.length);
	// offset += array.length;
	// }
	//
	// return result;
	// }
	//
	//
	//

	// =======================================================================================

	// Data provider providing patient details for login
	
	
	@DataProvider(name = "createDetails",indices = {a})
	public static Object[][] createData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "create");
		return testObjArray;
	}
	
	@DataProvider(name = "patientDetails")
	public static Object[][] patientData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "Patient");
		return testObjArray;
	}

	@DataProvider(name = "DemoGraphicsChangePortalDetails", indices = { a })
	public static Object[][] DemoGraphicsChangePortalData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"DemoGraphicsChangePortal");
		return testObjArray;
	}

	// Data provider for Manage Access Permission
	@DataProvider(name = "ManageAccessPermissionDetails", indices = { a })
	public static Object[][] ManageAccessPermissionData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ManageAccessPermission");
		return testObjArray;
	}

	// Data provider for scan fold operations
	@DataProvider(name = "ScanfoldSettingsDetails", indices = { a })
	public static Object[][] ScanfoldSettingsData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ScanfoldSettings");
		return testObjArray;
	}

	// Data provider providing testTaskdetails
	@DataProvider(name = "taskSheetDetails")
	public static Object[][] testTaskData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "TaskSheet");
		return testObjArray;
	}

	// Data provider providing createpaterntdetails
	@DataProvider(name = "createpaterntDetails", indices = { a })
	public static Object[][] createpaterntData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"CreatePatient");
		return testObjArray;
	}

	// Data provider used for PosteriorSegment
	@DataProvider(name = "PosteriorSegmentDetails", indices = { a })
	public Object[][] PosteriorSegmentData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"PosteriorSegment");
		return testObjArray;

	}

	// Data provider used for AnteriorSegment
	@DataProvider(name = "AnteriorSegmentDetails", indices = { a })
	public Object[][] AnteriorSegmentData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AnteriorSegment");
		return testObjArray;

	}

	// Data provider used for ExternalExam
	@DataProvider(name = "ExternalExamDetails", indices = { a })
	public Object[][] ExternalExamData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ExternalExam");
		return testObjArray;
	}

	// Data provider used for ExternalExam
	@DataProvider(name = "NPLOutsideEncounterDetails", indices = { a })
	public Object[][] NPLOutsideEncounterData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"NPLOutsideEncounter");
		return testObjArray;
	}

	// Data Provider used for new patient with Encounter
	@DataProvider(name = "CreatePatientWithNewEncounterDetails", indices = { a })
	public static Object[][] CreatePatientWithNewEncounterData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"CreatePatientWithNewEncounter");
		return testObjArray;
	}

	// Data provider used for InterMagic Rule
	@DataProvider(name = "UserMgtIntermagicRuleDetails", indices = { a })
	public static Object[][] UserMgtIntermagicRuleData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"UserMgtIntermagicRule");
		return testObjArray;

	}

	// Data provider used for Recon dashBoard
	@DataProvider(name = "ReconDashBoardDetails", indices = { a })
	public static Object[][] ReconDashBoardData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ReconDashBoard");
		return testObjArray;
	}

	// Data provider used for LogOutAndHold
	@DataProvider(name = "LogOutAndHoldDetails", indices = { a })
	public static Object[][] LogOutAndHoldData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"LogOutAndHold");
		return testObjArray;
	}

	// Data provider used for Edit Demographics With Integriview
	@DataProvider(name = "EditDemographicsWithIntegriviewDetails", indices = { a })
	public static Object[][] EditDemographicsWithIntegriviewData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"EditDemographicsWithIntegriview");
		return testObjArray;
	}

	// Data provider used for ESurgery With All Condition
	@DataProvider(name = "SurgeryWithAllConditionDetails", indices = { a })
	public static Object[][] SurgeryWithAllConditionData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"SurgeryWithAllCondition");
		return testObjArray;
	}

	// Data provider used for SurgeryWithTemplate
	@DataProvider(name = "SurgeryWithTemplateDetails", indices = { a })
	public Object[][] SurgeryWithTemplateData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"SurgeryWithTemplate");
		return testObjArray;
	}

	// Data provider used for With Or Without Supervising Provide
	@DataProvider(name = "WithOrWithoutSupervisingProvideDetails", indices = { a })
	public static Object[][] WithOrWithoutSupervisingProvideData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"WithOrWithoutSupervisingProvide");
		return testObjArray;
	}

	// Data provider used for ReconFin
	@DataProvider(name = "ReconFinDetails", indices = { a })
	public static Object[][] ReconFinData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "ReconFin");
		return testObjArray;
	}

	// Data provider used for With Or Without Supervising Provide
	@DataProvider(name = "UserMgtWithNotifyProviderDetails", indices = { a })
	public static Object[][] UserMgtWithNotifyProviderData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"UserMgtWithNotifyProvider");
		return testObjArray;
	}

	// Data provider used for DoctorNote
	@DataProvider(name = "DoctorNoteDetails", indices = { a })
	public static Object[][] DoctorNoteData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"DoctorNote");
		return testObjArray;
	}

	// Data provider used for PersonalTouch
	@DataProvider(name = "PersonalTouchDetails", indices = { a })
	public static Object[][] PersonalTouchData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"PersonalTouch");
		return testObjArray;
	}

	// Data provider used for MatchEncounterDate
	@DataProvider(name = "MatchEncounterDateDetails", indices = { a })
	public static Object[][] MatchEncounterDateData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"MatchEncounterDate");
		return testObjArray;
	}

	// Data provider used for VerifyAssociatesProvider
	@DataProvider(name = "VerifyAssociatesProviderDetails", indices = { a })
	public static Object[][] VerifyAssociatesProviderData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"VerifyAssociatesProvider");
		return testObjArray;
	}

	// Data provider used for AddCCandHPI
	@DataProvider(name = "AddCCandHPIDetails", indices = { a })
	public static Object[][] AddCCandHPIData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddCCandHPI");
		return testObjArray;
	}

	// Data provider used for VisionSummaryData
	@DataProvider(name = "VisionSummaryDataDetails", indices = { a })
	public static Object[][] VisionSummaryData1() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"VisionSummaryData");
		return testObjArray;
	}

	// Data provider used for AddCustomCL
	@DataProvider(name = "AddCustomCLDetails", indices = { a })
	public static Object[][] AddCustomCLData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddCustomCL");
		return testObjArray;
	}

	// Data provider used for UserDashBoardLink
	@DataProvider(name = "FamilyHistoryDetails", indices = { a })
	public static Object[][] FamilyHistorykData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"FamilyHistory");
		return testObjArray;
	}

	// Data provider used for UserDashBoardLink
	@DataProvider(name = "UserDashBoardLinkDetails", indices = { a })
	public static Object[][] UserDashBoardLinkData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"UserDashBoardLink");
		return testObjArray;
	}

	// PatientSearch
	@DataProvider(name = "patientSearchDetails")
	public static Object[][] patientSearchData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"PatientSearch");
		return testObjArray;
	}

	// Data Provider for OpthalmoscopyReports
	@DataProvider(name = "OpthalmoscopyReportsDetails", indices = { a })
	public static Object[][] OpthalmoscopyReportsData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"OpthalmoscopyReports");
		return testObjArray;

	}

	// Data provider used for InterpretationOpthalmoscopy
	@DataProvider(name = "InterpretationOpthalmoscopyDetails", indices = { a })
	public static Object[][] InterpretationOpthalmoscopyData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"InterpretationOpthalmoscopy");
		return testObjArray;
	}

	// Data provider used for ClinicNoteWithImage
	@DataProvider(name = "ClinicNoteWithImageDetails", indices = { a })
	public static Object[][] ClinicNoteWithImageData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ClinicNoteWithImage");
		return testObjArray;
	}

	// Data provider used for Import CCDA
	@DataProvider(name = "ImportCCDADetails", indices = { a })
	public static Object[][] ImportCCDAData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ImportCCDA");
		return testObjArray;
	}

	// Data Provider used for AdvanceSearch
	@DataProvider(name = "AdvanceSrchDetails", indices = { a })
	public static Object[][] advanceSrchData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AdvanceSrch");
		return testObjArray;
	}

	// Data provider used for MissleanousExample
	@DataProvider(name = "MissleanousExampledetails", indices = { a })
	public static Object[][] MissleanousExampleData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"MissleanousExample");
		return testObjArray;
	}

	// Data provider used for AddCDS
	@DataProvider(name = "AddCDSDetails", indices = { a })
	public static Object[][] AddCDSData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "AddCDS");
		return testObjArray;
	}

	// Data Provider for PatientEducationReports
	@DataProvider(name = "PatientEducationDetails", indices = { a })
	public static Object[][] PatientEducationData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"PatientEducation");
		return testObjArray;

	}

	// PatientModification
	@DataProvider(name = "patientModificationDetails")
	public static Object[][] patientModificationData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ModifyPatient");
		return testObjArray;
	}

	@DataProvider(name = "ConfigureClinicalDesicionSuppotrDetails")
	public static Object[][] ClinicalDesicionSuppotrData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ClinicalDecisionSupport");
		return testObjArray;
	}

	@DataProvider(name = "deletePatientDetails")
	public static Object[][] deletePatientData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"DeletePatient");
		return testObjArray;
	}

	@DataProvider(name = "visionSummaryDetails")
	public static Object[][] VisionSummaryData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"VisionSummary");
		return testObjArray;
	}

	// Data provider used to provide login ERPcredentials
	@DataProvider(name = "ERPLoginCredentials", indices = { a })
	public static Object[][] ERPcredentials() throws Exception {
		return XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "ERPLogin");
	}

	// Data provider used to provide refillRequest

	@DataProvider(name = "refillRequestDetails1")
	public static Object[][] refillRequestData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"RefillReq1");
		return testObjArray;
	}

	// Data provider used for MedAndAllergieWithEducation
	@DataProvider(name = "MedAndAllergieWithEducationDetails", indices = { a })
	public static Object[][] MedAndAllergieWithEducationData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"MedAndAllergieWithEducation");
		return testObjArray;
	}
	// Data provider used to provide MedicationOcular

	@DataProvider(name = "medicationOcularDetails", indices = { a })
	public static Object[][] medicationOcularData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"MedicationOcular");
		return testObjArray;
	}

	// Data provider used for InactiveMedicalProblem
	@DataProvider(name = "InactiveMedicalProblemDetails", indices = { a })
	public static Object[][] InactiveMedicalProblemData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"InactiveMedicalProblem");
		return testObjArray;
	}

	// Data provider used for RcpInegration
	@DataProvider(name = "RcpInegrationDetails", indices = { a })
	public static Object[][] RcpInegrationData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"RcpInegration");
		return testObjArray;
	}

	// Data provider used to provide Medication

	@DataProvider(name = "medicationDetails")
	public static Object[][] medicationData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"Medication");
		return testObjArray;
	}

	// Data provider used to AdvancedMDCreatePatient

	@DataProvider(name = "AdvancedMDCreatePatientDetails", indices = { a })
	public static Object[][] AdvancedMDCreatePatientData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AdvancedMDCreatePatient");
		return testObjArray;
	}

	// Data provider used to AdvancedMDEditPatient

	@DataProvider(name = "AdvancedMdEditPatientDetails", indices = { a })
	public static Object[][] AdvancedMdEditPatientData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AdvancedMdEditPatient");
		return testObjArray;
	}

	// Data Provider used for Advanced Md Ext Provider
	@DataProvider(name = "AdvancedMDExtProviderDetails", indices = { a })
	public static Object[][] AdvancedMDExtProviderData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AdvancedMDExtProvider");
		return testObjArray;
	}

	// Data provider used to Schedular Appontment
	@DataProvider(name = "SchedularAppointmentDetails")
	public static Object[][] SchedularAppointmentData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"SchedularAppointment");
		return testObjArray;
	}

	// Data provider used to PatientTag

	@DataProvider(name = "PatientTagsDetails", indices = { a })
	public static Object[][] PatientTagsData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"PatientTag");
		return testObjArray;
	}

	// Data provider used for ConfigureRoomList
	@DataProvider(name = "ConfigureRoomListDetails", indices = { a })
	public static Object[][] ConfigureRoomListData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ConfigureRoomList");
		return testObjArray;
	}

	// Data provider used to DrFirst

	@DataProvider(name = "DrFirstDetails", indices = { a })
	public static Object[][] DrFirstData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "DrFirst");
		return testObjArray;
	}

	// Data Provider used for add allergies
	@DataProvider(name = "AddAllergiesDetails", indices = { a })
	public static Object[][] AddAllergiesData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddAllergies");
		return testObjArray;
	}

	// Data provider used for Update Allergies
	@DataProvider(name = "UpdateAllergiesDetails", indices = { a })
	public static Object[][] UpdateAllergiesData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"UpdateAllergies");
		return testObjArray;

	}

	// Data provider used to ERPEducationResources

	@DataProvider(name = "EducationsResourcesDetails")
	public static Object[][] EducationsResourcesData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"EducationResources");
		return testObjArray;
	}

	// Data provider used to ERPPatientModification

	@DataProvider(name = "PatientModificationDetails", indices = { a })
	public static Object[][] PatientModificationsData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"PatientModification");
		return testObjArray;
	}

	// Data provider is usec for CreatePatientWithPortalAccount
	@DataProvider(name = "CreatePatientWithPortalAccountDetails", indices = { a })
	public static Object[][] CreatePatientWithPortalAccountData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"createPatientWithPoratlAccount");
		return testObjArray;
	}

	// Data provider used to ERPAddReprestantive

	@DataProvider(name = "ErpAddReprestantiveDetails", indices = { a })
	public static Object[][] ErpAddReprestantiveData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ErpAddReprestantive");
		return testObjArray;
	}

	// Data provider used for Add Procedures
	@DataProvider(name = "AddProceduresDetails", indices = { a })
	public static Object[][] AddProceduresData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddProcedures");
		return testObjArray;
	}

	// DataProvider used for RadiologyReport
	@DataProvider(name = "RadioLogyReportDetails", indices = { a })
	public static Object[][] radioLogyData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"RadioLogyReport");
		return testObjArray;
	}

	// DataProvider used for OrderEyeTest
	@DataProvider(name = "OrderEyeTestDetails", indices = { a })
	public static Object[][] OrderEyeTestData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"OrderEyeTest");
		return testObjArray;
	}

	// DataProvider used for OTCMediactionTest
	@DataProvider(name = "OTCMediactionTestDetails", indices = { a })
	public static Object[][] OTCMediactionTestData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"OTCMediactionTest");
		return testObjArray;
	}

	// dataProvider for SensorimotorExam
	@DataProvider(name = "SensorimotorExamDetails", indices = { a })
	public static Object[][] SensorimotorExamData() throws Exception {

		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"SensorimotorExam");
		return testObjArray;
	}

	// Data provider used for GonioscopyExam
	@DataProvider(name = "GonioscopyExamDetails", indices = { a })
	public static Object[][] GonioscopyExamData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"GonioscopyExam");
		return testObjArray;
	}

	// Data provider used for Add appointment
	@DataProvider(name = "AddApointment1Details", indices = { a })
	public static Object[][] AddApointmentData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddApointment1");
		return testObjArray;

	}

	// dataProvider for Auditsearch
	@DataProvider(name = "AuditSearchDetails", indices = { a })
	public static Object[][] AuditSearchData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AuditSearch");
		return testObjArray;

	}

	// Data provider for settingSurgery
	@DataProvider(name = "SeetingSurgeryDetails", indices = { a })
	public static Object[][] settingSurgeryData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"SettingSurgery");
		return testObjArray;
	}

	// Data provider for SurgeryPatient With encounter
	@DataProvider(name = "SurgeryPatientWithencounterDetails", indices = { a })
	public static Object[][] SurgeryPatientWithencounterData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"SurgeryPatientWithencounter");
		return testObjArray;

	}

	// Data Provider for delete surgery patient
	@DataProvider(name = "DeleteSurgerySchedulePatientDetails", indices = { a })
	public static Object[][] DeleteSurgerySchedulePatientData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"DeleteSurgerySchedulePatient");
		return testObjArray;
	}

	// Data Provider for Intravitreal Injection
	@DataProvider(name = "IntravitrealInjectionDetails", indices = { a })
	public static Object[][] IntravitrealInjectionData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"IntravitrealInjection");
		return testObjArray;

	}

	// Data provider used to Correspondence With todays
	@DataProvider(name = "CorrespondenceReportTodaysdetails", indices = { a })
	public static Object[][] correspondenceReportTodaysData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"CorrespondenceReportTodays");
		return testObjArray;
	}

	// Fata provider used to Correspondence Report With PastDay
	@DataProvider(name = "CorrespondenceReportWithPastDayDetails", indices = { a })
	public static Object[][] correspondenceReportWithPastDayData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"CorrespondenceReportWithPastDay");
		return testObjArray;
	}

	// Data provider used to Edit Vital Signs

	@DataProvider(name = "EditVitalSignsDetails", indices = { a })
	public static Object[][] EditVitalSignsData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"EditVitalSigns");
		return testObjArray;
	}

	// Data provider used to Vital Signs

	@DataProvider(name = "VitalSignsDetails", indices = { a })
	public static Object[][] VitalSignsData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"VitalSigns");
		return testObjArray;
	}

	// Data provider used to Add Lab Order

	@DataProvider(name = "AddLabOrderDetails", indices = { a })
	public static Object[][] addLabOrderData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "LabOrder");
		return testObjArray;
	}

	// Data provider used for Add New Contact Lens

	@DataProvider(name = "AddNewContactLensDetails", indices = { a })
	public static Object[][] AddNewContactLensData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddNewContactLens");
		return testObjArray;
	}

	// Data provider used to Encounter

	@DataProvider(name = "EncounterDetails")
	public static Object[][] EncounterData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "Encounter");
		return testObjArray;
	}

	// Data provider used to modifyEncounter

	@DataProvider(name = "ImportExistingGlassDetails", indices = { a })
	public static Object[][] ImportExistingGlassData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ImportExistingGlass");
		return testObjArray;
	}

	// Data provider used to EncounterExistingGlass

	@DataProvider(name = "ExistingGlassDetails", indices = { a })
	public static Object[][] ExistingGlassData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ExistingGlass");
		return testObjArray;
	}

	// DataProvider used for UnCorrectedVA
	@DataProvider(name = "AddUncorrectedVADetails", indices = { a })
	public static Object[][] AddUncorrectedVAData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddUncorrectedVA");
		return testObjArray;
	}

	// DataProvider used for Edit Uncorrected VA
	@DataProvider(name = "EditUncorrectedVADetails", indices = { a })
	public static Object[][] EditUncorrectedVAData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"EditUncorrectedVA");
		return testObjArray;
	}

	// DataProvider used to DeleteUnCorretedVa
	@DataProvider(name = "DeleteUncorretedVADetails")
	public static Object[][] deleteUncorretedVAData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"DeleteUncorretedVA");
		return testObjArray;
	}

	// DataProvider used to DeleteAndImportExisting Glass
	@DataProvider(name = "AddAndDeleteExistingGlassDetails", indices = { a })
	public static Object[][] AddAndDeleteExistingGlassData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddAndDeleteExistingGlass");
		return testObjArray;

	}

	// Data provider used to EncounterRefraction

	@DataProvider(name = "RefractionDetails", indices = { a })
	public static Object[][] RefractionData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"Refraction");
		return testObjArray;
	}

	// Data Provider used to Add and delete Refraction
	@DataProvider(name = "AddAndDeleteRefractionDetails", indices = { a })
	public static Object[][] addAndDeleteRefractionData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddAndDeleteRefraction");
		return testObjArray;

	}

	// Data Provider used to import Refraction
	@DataProvider(name = "ImportRefractionDetails", indices = { a })
	public static Object[][] importRefractionData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ImportRefraction");
		return testObjArray;

	}

	// Data provider used to EncounterContactLens

	@DataProvider(name = "ContactLensDetails")
	public static Object[][] ContactLensData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"NewContactLens");
		return testObjArray;
	}

	// Data provider used for immunization
	@DataProvider(name = "ImmunizationDetails", indices = { a })
	public static Object[][] immunizationData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"Immunization");
		return testObjArray;
	}

	// Data Provider used to TechExam
	@DataProvider(name = "TechExamDetails", indices = { a })
	public static Object[][] TechExamData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "TechExam");
		return testObjArray;

	}

	// Data Provider used to visionRefraction
	@DataProvider(name = "VisionRefractionDetails", indices = { a })
	public static Object[][] visionRefractionData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				" VisionRefraction");
		return testObjArray;

	}

	// Data provider used for PrescibeContact
	@DataProvider(name = "PrescibeContactDeatils", indices = { a })
	public static Object[][] PrescibeContactData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"PrescibeContact");
		return testObjArray;
	}

	// Data provider used to EncounterKeratometry

	@DataProvider(name = "KeratometryDetails", indices = { a })
	public static Object[][] KeratometryData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"Keratometry");
		return testObjArray;
	}

	// Data Provider used to add Keratomatery Data

	@DataProvider(name = "AddKeratomateryDetails", indices = { a })
	public static Object[][] addKeratomateryData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddKeratomatery");
		return testObjArray;
	}

	// Data provider used for restore vision config
	@DataProvider(name = "RestoreVisionConfigDetails", indices = { a })
	public static Object[][] RestoreVisionConfigData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"RestoreVisionConfig");
		return testObjArray;
	}

	// Data provider used to ErpFileSharing

	@DataProvider(name = "ErpFileSharingDetails", indices = { a })
	public static Object[][] ErpFileSharingData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ErpFileSharing");
		return testObjArray;
	}

	// Data Provider used for Sending information to represtantive portal
	@DataProvider(name = "SendingInfoRepPortalDetails", indices = { a })
	public static Object[][] SendingInfoRepPortalData() throws Exception {
		Object[][] testObjarray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"SendingInfoRepPortal");
		return testObjarray;
	}

	// Data Provider used for close Encounter
	@DataProvider(name = "CloseEncounterDetails", indices = { a })
	public static Object[][] closeEncounterData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"CloseEnconter");
		return testObjArray;
	}

	// Data Provider used for CloseEncounterWithPopUp
	@DataProvider(name = "CloseEncounterWithPopUpDetails", indices = { a })
	public static Object[][] CloseEncounterWithPopUpData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"CloseEncounterWithPopUp");
		return testObjArray;
	}

	// Data Provider used for ASCIntegration
	@DataProvider(name = "ASCIntegrationDetails", indices = { a })
	public static Object[][] ASCIntegrationData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ASCIntegration");
		return testObjArray;
	}

	// Data Provider used for ASCIntegrationPopUpWindow
	@DataProvider(name = "ASCIntegrationPopUpWindowDetails", indices = { a })
	public static Object[][] ASCIntegrationPopUpWindowData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ASCIntegrationPopUpWindow");
		return testObjArray;
	}
	
	//Data Provider used for LinkAppointmentWithSurgery
	@DataProvider(name="LinkAppointmentWithSurgeryDetails",indices = {a})
	public static Object[][] LinkAppointmentWithSurgeryDetails()throws Exception{
		Object[][] testObjArray=XLConnect.getXLSXData(ProjectSettings.xlFile+"IngetrityTestData.xlsx", "LinkAppointmentWithSurgery");
		return testObjArray;
	}

	// Data Provider used for ComanagingDoctors
	@DataProvider(name = "ComanagingDoctorsDetails", indices = { a })
	public static Object[][] ComanagingDoctorsData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ComanagingDoctors");
		return testObjArray;
	}

	// Data Provider used for ClinicSiteUserProfile
	@DataProvider(name = "ClinicSiteUserProfileDetails", indices = { a })
	public static Object[][] ClinicSiteUserProfileData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ClinicSiteUserProfile");
		return testObjArray;
	}

	// Data provider used to matchErpFileSharing

	// @DataProvider(name = "MatchErpFileSharingDetails")
	// public static Object[][] MatchErpFileSharingData() throws Exception {
	// Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile +
	// "IngetrityTestData.xlsx",
	// "MatchFileSharing");
	// return testObjArray;
	// }

	// Data Provider used for Notify Provider Without Encounter

	@DataProvider(name = "NotifyProviderWithoutEncounterDetails", indices = { a })
	public static Object[][] NotifyProviderWithoutEncounterData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"NotifyProviderWithoutEncounter");
		return testObjArray;
	}

	// Data Provider used for Refferal and report

	@DataProvider(name = "RefferalAndFollowUpReportDetails", indices = { a })
	public static Object[][] RefferalAndFollowUpReportData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"RefferalAndFollowUpReport");
		return testObjArray;
	}

	// Data Provider used for refer patient to doctor

	@DataProvider(name = "ReferPatientToDocterdetails", indices = { a })
	public static Object[][] ReferPatientToDocterData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ReferPatientToDocter");
		return testObjArray;
	}

	// Data Provider used fpr send direct messge to internal provider

	@DataProvider(name = "DirectMessageToProviderDetails", indices = { a })
	public static Object[][] DirectMessageToProviderData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"DirectMessageToProvider");
		return testObjArray;
	}

	// Data Provider used for generating and printing Reffreal Reply Doc
	@DataProvider(name = "GeneratingAndPrintingRefferalDetails", indices = { a })
	public static Object[][] GeneratingAndPrintingRefferalData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"GeneratingAndPrintingRefferalDo");
		return testObjArray;
	}

	// Data Provider used for secure Msg
	@DataProvider(name = "ERPSecureMsgDetails", indices = { a })
	public static Object[][] ERPSecureMsgData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ERPSecureMsg");
		return testObjArray;
	}

	// Data provider used for remove document from document center
	@DataProvider(name = "RemoveDocumentDetails", indices = { a })
	public static Object[][] RemoveDocumentData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"RemoveDocument");
		return testObjArray;
	}

	// DataProvider used for AddAddendumVlaue
	@DataProvider(name = "AddAddendumVlaueDetails")
	public static Object[][] AddAddendumVlaueData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AddendumValue");
		return testObjArray;
	}

	// Data provider used to pendingPatient

	@DataProvider(name = "PendingPatientDetails")
	public static Object[][] PendingPatientData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"PendingPatient");
		return testObjArray;
	}

	// Data provider used to SurgeryPatient

	@DataProvider(name = "SurgeryPatientDetails", indices = { a })
	public static Object[][] SurgeryPatientData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"SurgeryPatient");
		return testObjArray;
	}

	// gridexample

	@DataProvider(name = "GridexampleDetails")
	public static Object[][] GridexampleData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"GridExample");
		return testObjArray;
	}

	@DataProvider(name = "contactLensDetails")
	public static Object[][] contactLensData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ContactLens");
		return testObjArray;
	}

	@DataProvider(name = "configureLensDetails")
	public static Object[][] configureLensData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ConfigureLens");
		return testObjArray;
	}

	@DataProvider(name = "ConfigBinocularPinholeDetails")
	public static Object[][] configureBinocularPinholeData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"BinocularPinhole");
		return testObjArray;
	}

	// DataProvider for dominantEyeCheck

	@DataProvider(name = "DominantEyeDetails")
	public static Object[][] DominantEyeData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"DominantEye");
		return testObjArray;
	}

	// DataProvider for advanceSearch

	@DataProvider(name = "AdvanceSearchDetails")
	public static Object[][] AdvanceSearchData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AdvanceSearch");
		return testObjArray;
	}

	@DataProvider(name = "ProcedureDetails", indices = { a })
	public static Object[][] procedureData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "Procedure");
		return testObjArray;
	}

	@DataProvider(name = "SurgerySitetDetails", indices = { a })
	public static Object[][] SurgerySiteData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"SurgerySite");
		return testObjArray;
	}

	@DataProvider(name = "SessionTimeOutDetails")
	public static Object[][] SessionTimeOutData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"SessionTimeOut");
		return testObjArray;
	}

	@DataProvider(name = "authroziedRepresentativeDetails")
	public static Object[][] authroziedRepresentativeData() throws Exception {
		Object[][] testObjArray = XLConnect.getXLSXData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"AuthroziedRepresentative");
		return testObjArray;
	}

	@DataProvider(name = "providerDetails", indices = { a })
	public static Object[][] providerData() throws Exception {
		Object[][] testObjArray = XLConnect.getData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "Provider");
		return testObjArray;
	}

	@DataProvider(name = "userManagmentDetails", indices = { a })
	public static Object[][] userMangmentData() throws Exception {
		Object[][] testObjArray = XLConnect.getData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "UserManagment");
		return testObjArray;
	}

	@DataProvider(name = "getDetailsForPatientSearch")
	public static Object[][] geDetailsForPatientSearch() throws Exception {
		return XLConnect.getPatientDetailsForSearch(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "Patient");
	}

	@DataProvider(name = "addendum")
	public static Object[][] addendum() throws Exception {
		Object[][] testObjArray = XLConnect.getData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "Addendum");
		return testObjArray;
	}

	@DataProvider(name = "ccAndHPIValue")
	public static Object[][] ccAndHPIValue() throws Exception {
		Object[][] testObjArray = XLConnect.getData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "CC_AND_HPI");
		return testObjArray;
	}

	@DataProvider(name = "eyeHistoryValue")
	public static Object[][] eyeHistoryValue() throws Exception {
		Object[][] testObjArray = XLConnect.getData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"EYE_HISTORY_VALUE");
		return testObjArray;
	}

	@DataProvider(name = "AppointmentDetail")
	public static Object[][] AppointmnetData() throws Exception {
		Object[][] testObjArray = XLConnect.getData(ProjectSettings.xlFile + "IngetrityTestData.xlsx", "Appointment");
		return testObjArray;
	}

	@DataProvider(name = "composeMessageDetail")
	public static Object[][] composeMessageDetail() throws Exception {
		Object[][] testObjArray = XLConnect.getData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ComposeMessage");
		return testObjArray;
	}

	// ScheduleNewSergery
	@DataProvider(name = "scheduleNewSurgeryTestDetail")
	public static Object[][] scheduleNewSurgeryTestDetail() throws Exception {
		Object[][] testObjArray = XLConnect.getData(ProjectSettings.xlFile + "IngetrityTestData.xlsx",
				"ScheduleNewSurgery");
		return testObjArray;

	}

}