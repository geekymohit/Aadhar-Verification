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


import java.io.Serializable;

/**
 * 
 * <code>AuthenticationRequestData</code> class is used for collecting various information from 
 * the GUI so that it can be used for creating Pid and Auth objects.
 * 
 * @author UIDAI
 *
 */
public class AuthenticationRequestData implements Serializable {

    /**
     * generated serial version id
     */
    private static final long serialVersionUID = -969857695481409943L;


    private String uid;
    private String name;

    private MatchingStrategy nameMatchStrategy;
    private MatchingStrategy addressMatchStrategy;

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }





    public MatchingStrategy getNameMatchStrategy() {
        return nameMatchStrategy;
    }

    public void setNameMatchStrategy(MatchingStrategy nameMatchStrategy) {
        this.nameMatchStrategy = nameMatchStrategy;
    }





    

}
