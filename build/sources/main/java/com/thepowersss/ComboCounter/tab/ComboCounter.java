package com.thepowersss.ComboCounter.tab;


import com.thepowersss.ComboCounter.client.commands.CommandDisable;
import com.thepowersss.ComboCounter.client.commands.CommandEnable;
import com.thepowersss.ComboCounter.proxy.CommonProxy;
import com.thepowersss.ComboCounter.util.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class ComboCounter {

    @Instance
    public static ComboCounter instance;
    private static int hits = 0;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    public static final ComboCounterEventHandler HANDLER = new ComboCounterEventHandler();

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public static void Init(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public static void PostInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(HANDLER);
    }

    public static void resetHits() {
        hits = 0;
    }

    public static void incrementHits() {
        hits++;
        System.out.println(hits);
    }

    public static int getHits() {
        return hits;
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
        // register server commands

        event.registerServerCommand(new CommandEnable());
        event.registerServerCommand(new CommandDisable());
    }

    public static void disable() {

    }
}


