/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.apache.kerby.x509.type;

import org.apache.kerby.asn1.Asn1FieldInfo;
import org.apache.kerby.asn1.EnumType;
import org.apache.kerby.asn1.ExplicitField;
import org.apache.kerby.asn1.type.Asn1Any;
import org.apache.kerby.asn1.type.Asn1Choice;
import org.apache.kerby.asn1.type.Asn1IA5String;
import org.apache.kerby.asn1.type.Asn1ObjectIdentifier;
import org.apache.kerby.asn1.type.Asn1OctetString;
import org.apache.kerby.x500.type.Name;

import static org.apache.kerby.x509.type.GeneralName.MyEnum.*;

/**
 *
 * <pre>
 * GeneralName ::= CHOICE {
 *      otherName                       [0]     OtherName,
 *      rfc822Name                      [1]     IA5String,
 *      dNSName                         [2]     IA5String,
 *      x400Address                     [3]     ORAddress,
 *      directoryName                   [4]     Name,
 *      ediPartyName                    [5]     EDIPartyName,
 *      uniformResourceIdentifier       [6]     IA5String,
 *      iPAddress                       [7]     OCTET STRING,
 *      registeredID                    [8]     OBJECT IDENTIFIER
 *  }
 * </pre>
 */
public class GeneralName extends Asn1Choice {
    protected enum MyEnum implements EnumType {
        OTHER_NAME,
        RFC822_NAME,
        DNS_NAME,
        X400_ADDRESS,
        DIRECTORY_NAME,
        EDI_PARTY_NAME,
        UNIFORM_RESOURCE_IDENTIFIER,
        IP_ADDRESS,
        REGISTERED_ID;

        @Override
        public int getValue() {
            return ordinal();
        }

        @Override
        public String getName() {
            return name();
        }
    }

    static Asn1FieldInfo[] fieldInfos = new Asn1FieldInfo[] {
        new ExplicitField(OTHER_NAME, OtherName.class),
        new ExplicitField(RFC822_NAME, Asn1IA5String.class),
        new ExplicitField(DNS_NAME, Asn1IA5String.class),
        // ORAddress is to be defined.
        new ExplicitField(X400_ADDRESS, Asn1Any.class),
        new ExplicitField(DIRECTORY_NAME, Name.class),
        new ExplicitField(EDI_PARTY_NAME, EDIPartyName.class),
        new ExplicitField(UNIFORM_RESOURCE_IDENTIFIER, Asn1IA5String.class),
        new ExplicitField(IP_ADDRESS, Asn1OctetString.class),
        new ExplicitField(REGISTERED_ID, Asn1ObjectIdentifier.class)
    };

    public GeneralName() {
        super(fieldInfos);
    }

    public OtherName getOtherName() {
        return getFieldAs(OTHER_NAME, OtherName.class);
    }

    public void setOtherName(OtherName otherName) {
        setFieldAs(OTHER_NAME, otherName);
    }

    public Asn1IA5String getRfc822Name() {
        return getFieldAs(RFC822_NAME, Asn1IA5String.class);
    }

    public void setRfc822Name(Asn1IA5String rfc822Name) {
        setFieldAs(RFC822_NAME, rfc822Name);
    }

    public Asn1IA5String getDNSName() {
        return getFieldAs(DNS_NAME, Asn1IA5String.class);
    }

    public void setDNSName(Asn1IA5String dnsName) {
        setFieldAs(DNS_NAME, dnsName);
    }

    public Asn1Any getX400Address() {
        return getFieldAs(X400_ADDRESS, Asn1Any.class);
    }

    public void setX400Address(Asn1Any x400Address) {
        setFieldAs(X400_ADDRESS, x400Address);
    }

    public Name getDirectoryName() {
        return getFieldAs(DIRECTORY_NAME, Name.class);
    }

    public void setDirectoryName(Name directoryName) {
        setFieldAs(DIRECTORY_NAME, directoryName);
    }

    public EDIPartyName getEdiPartyName() {
        return getFieldAs(EDI_PARTY_NAME, EDIPartyName.class);
    }

    public void setEdiPartyName(EDIPartyName ediPartyName) {
        setFieldAs(EDI_PARTY_NAME, ediPartyName);
    }

    public Asn1IA5String getUniformResourceIdentifier() {
        return getFieldAs(UNIFORM_RESOURCE_IDENTIFIER, Asn1IA5String.class);
    }

    public void setUniformResourceIdentifier(Asn1IA5String uniformResourceIdentifier) {
        setFieldAs(UNIFORM_RESOURCE_IDENTIFIER, uniformResourceIdentifier);
    }

    public Asn1OctetString getIPAddress() {
        return getFieldAs(IP_ADDRESS, Asn1OctetString.class);
    }

    public void setIpAddress(Asn1OctetString ipAddress) {
        setFieldAs(IP_ADDRESS, ipAddress);
    }

    public Asn1ObjectIdentifier getRegisteredID() {
        return getFieldAs(REGISTERED_ID, Asn1ObjectIdentifier.class);
    }

    public void setRegisteredID(Asn1ObjectIdentifier registeredID) {
        setFieldAs(REGISTERED_ID, registeredID);
    }
}
