package com.thepowersss.ComboCounter.tab;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ComboCounterEventHandler {

    private int ticksPassed = 0;

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void livingHurt(LivingHurtEvent event) {
        if (event.getEntity().equals(Minecraft.getMinecraft().player)) {
            if (!(event.getSource().getImmediateSource().equals(DamageSource.FALL)) && (event.getSource().getTrueSource() instanceof Entity)) {
                if (ComboCounter.getHits() != 0)
                    Minecraft.getMinecraft().player.sendStatusMessage(new TextComponentString(("" + ComboCounter.getHits() + " hit combo!")), true);
                ComboCounter.resetHits();
            }
        }
        else if (event.getEntity() instanceof Entity) { //replace with player in future
            if ( event.getSource().getTrueSource() != null && event.getSource().getTrueSource().equals(Minecraft.getMinecraft().player)) {
                if (event.getSource() != DamageSource.ON_FIRE && event.getSource() != DamageSource.MAGIC && event.getSource() != DamageSource.STARVE)
                    ComboCounter.incrementHits();
                    ticksPassed = 0;
            }
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onClientTick(TickEvent.ClientTickEvent event) {
        ticksPassed++;
        if (ticksPassed % 100 == 0) {
            if (Minecraft.getMinecraft().player != null) {
                if (ComboCounter.getHits() != 0)
                    Minecraft.getMinecraft().player.sendStatusMessage(new TextComponentString(("" + ComboCounter.getHits() + " hit combo!")), true);
                ComboCounter.resetHits();
            }
        }
    }
}
