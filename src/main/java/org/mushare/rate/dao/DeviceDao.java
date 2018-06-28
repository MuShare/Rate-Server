package org.mushare.rate.dao;

import org.mushare.common.hibernate.support.BaseDao;
import org.mushare.rate.domain.Device;
import org.mushare.rate.domain.User;

import java.util.List;

public interface DeviceDao extends BaseDao<Device> {

    /**
     * Get a device by identifier.
     * @param identifier
     * @return
     */
    Device getByIdentifier(String identifier);

    /**
     * Get a device by login token
     * @param token
     * @return
     */
    Device getByToken(String token);

    /**
     * Get a device by device token.
     *
     * @param deviceToken
     * @return
     */
    Device getByDeviceToken(String deviceToken);

    /**
     * Find all devices of a user.
     *
     * @param user
     * @return
     */
    List<Device> findByUser(User user);

}
