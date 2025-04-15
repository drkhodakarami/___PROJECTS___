package jiraiyah.ultraio.compat.jade;

import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;

public class ModJadePlugin implements IWailaPlugin
{
    @Override
    public void register(IWailaCommonRegistration registration)
    {
        IWailaPlugin.super.register(registration);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration)
    {
        IWailaPlugin.super.registerClient(registration);
    }
}