/*******************************************************************************
 * DISCLAIMER: The sample code or utility or tool described herein
 *    is provided on an "as is" basis, without warranty of any kind.
 *    UIDAI does not warrant or guarantee the individual success
 *    developers may have in implementing the sample code on their
 *    environment. 
 *    
 *    UIDAI does not warrant, guarantee or make any representations
 *    of any kind with respect to the sample code and does not make
 *    any representations or warranties regarding the use, results
 *    of use, accuracy, timeliness or completeness of any data or
 *    information relating to the sample code. UIDAI disclaims all
 *    warranties, express or implied, and in particular, disclaims
 *    all warranties of merchantability, fitness for a particular
 *    purpose, and warranties related to the code, or any service
 *    or software related thereto. 
 *    
 *    UIDAI is not responsible for and shall not be liable directly
 *    or indirectly for any direct, indirect damages or costs of any
 *    type arising out of use or any action taken by you or others
 *    related to the sample code.
 *    
 *    THIS IS NOT A SUPPORTED SOFTWARE.
 ******************************************************************************/
package com.example.mohit.aadharverification;

/**import in.gov.uidai.authentication.uid_auth_request._1.Uses;
import in.gov.uidai.authentication.uid_auth_request_data._1.Bio;
import in.gov.uidai.authentication.uid_auth_request_data._1.BioMetricType;
import in.gov.uidai.authentication.uid_auth_request_data._1.BiometricPosition;
import in.gov.uidai.authentication.uid_auth_request_data._1.Bios;
import in.gov.uidai.authentication.uid_auth_request_data._1.Demo;
import in.gov.uidai.authentication.uid_auth_request_data._1.Gender;
import in.gov.uidai.authentication.uid_auth_request_data._1.Meta;
import in.gov.uidai.authentication.uid_auth_request_data._1.Pa;
import in.gov.uidai.authentication.uid_auth_request_data._1.Pfa;
import in.gov.uidai.authentication.uid_auth_request_data._1.Pi;
import in.gov.uidai.authentication.uid_auth_request_data._1.Pid;
import in.gov.uidai.authentication.uid_auth_request_data._1.Pv;**/

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;



/**
 * <code>AuthRequestHelper</code> provides utility method to create Pid and Uses element.
 * 
 * 
 * @author UIDAI
 *
 */
public class AuthRequestHelper {

	public static Pid createPid(Meta metaData, AuthenticationRequestData data) {
		Map<String, String> languageToCodeMap = new HashMap<String, String>();
		languageToCodeMap.put("English", "23");
		languageToCodeMap.put("Hindi", "06");
		languageToCodeMap.put("Kannada", "07");
		languageToCodeMap.put("Malayalam", "11");

		Pid pid = new Pid();

		
		pid.setMeta(metaData);

		if (data != null) {
			Demo demo = new Demo();



			if (data.getName() != null && !data.getName().isEmpty()) {
				Pi pi = new Pi();
				pi.setMs(data.getNameMatchStrategy());

				pi.setName(data.getName());

			}

			}
			// Add Pa only if one of the constituent attributes have a value
			// specified
		return pid;
	}

	public static Uses createUses(AuthenticationFactors authfactors) {
		Uses uses = new Uses();
		uses.setPi(authfactors.isUsesPi() ? "y" : "n");

		return uses;
	}
}
