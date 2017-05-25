package com.rivetlogic.skype.config;

import aQute.bnd.annotation.metatype.Meta;

/**
 * Created by jorgewong on 2/23/17.
 */
@Meta.OCD(id = "com.rivetlogic.skype.config.Configuration")
public interface Configuration {

    @Meta.AD(deflt = "10", required = false)
    public String getDefaultDeltaView();
}
