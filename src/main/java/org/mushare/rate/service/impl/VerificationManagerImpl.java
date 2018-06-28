package org.mushare.rate.service.impl;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.mushare.rate.bean.VerificationBean;
import org.mushare.rate.domain.Verification;
import org.mushare.rate.service.VerificationManager;
import org.mushare.rate.service.common.ManagerTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RemoteProxy(name = "VerificationManager")
public class VerificationManagerImpl extends ManagerTemplate implements VerificationManager {

    public VerificationBean validate(String vid) {
        Verification verification = verificationDao.get(vid);
        if (verification == null) {
            return null;
        }
        if (System.currentTimeMillis() / 1000L - verification.getCreateAt() > configComponent.global.validity) {
            return null;
        }
        return new VerificationBean(verification);
    }

    @RemoteMethod
    public VerificationBean getVerificationFromSession(HttpSession session) {
        return (VerificationBean) session.getAttribute(VerificationFlag);
    }

}
