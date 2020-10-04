/*
 *       Copyright© (2019) WeBank Co., Ltd.
 *
 *       This file is part of weidentity-sample.
 *
 *       weidentity-sample is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU Lesser General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       weidentity-sample is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU Lesser General Public License for more details.
 *
 *       You should have received a copy of the GNU Lesser General Public License
 *       along with weidentity-sample.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.webank.weid.demo.service;

import com.webank.weid.demo.common.request.WeIdRequest;
import com.webank.weid.protocol.base.CptBaseInfo;
import com.webank.weid.protocol.base.CredentialWrapper;
import com.webank.weid.protocol.response.CreateWeIdDataResult;
import com.webank.weid.protocol.response.ResponseData;

import java.util.Map;

/**
 * demo interface.
 * 
 * @author v_wbgyang
 *
 */
public interface DemoService {

    /**
     * create weId with public and private keys and set related properties.
     * 
     * @param publicKey public key
     * @param privateKey private key
     * @return returns the create weId
     */
    ResponseData<String> createWeIdAndSetAttr(String publicKey, String privateKey);

    /**
     * create weId and set related properties.
     * 
     * @return returns the create weId  and public private keys
     */
    ResponseData<CreateWeIdDataResult> createWeId();

    /**
     * 创建Weid
     *
     * @param request 请求体
     * @return 响应
     */
    ResponseData<CreateWeIdDataResult> createWeId(WeIdRequest request);

    /**
     * register on the chain as an authoritative body.
     * 
     * @param authorityName the name of the issue
     * @return true is success, false is failure
     */
    ResponseData<Boolean> registerAuthorityIssuer(String issuer, String authorityName);

    /**
     * registered CPT.
     * 
     * @param publisher the weId of the publisher
     * @param privateKey the private key of the publisher
     * @param claim claim is CPT
     * @return returns cptBaseInfo
     */
    ResponseData<CptBaseInfo> registCpt(
        String publisher,
        String privateKey,
        Map<String, Object> claim
    );

    /**
     * create credential.
     *
     * @param cptId the cptId of CPT
     * @param issuer the weId of issue
     * @param privateKey the private key of issuer
     * @param claimDate the data of claim
     * @return returns credential
     */
    ResponseData<CredentialWrapper> createCredential(
        Integer cptId,
        String issuer,
        String privateKey,
        Map<String, Object> claimDate
    );

    /**
     * verifyEvidence credential.
     * 
     * @param credentialJson credentials in JSON format
     * @return returns the result of verifyEvidence
     */
    ResponseData<Boolean> verifyCredential(String credentialJson);
}
