package com.agarmal.colorful_flares;

import com.agarmal.colorful_flares.block.AllBlocks;
import com.agarmal.colorful_flares.entity.AllEntities;
import com.agarmal.colorful_flares.item.AllItems;
import com.agarmal.colorful_flares.particle.AllParticles;
import com.agarmal.colorful_flares.particle.FlareSmoke;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ColorfulFlares.MOD_ID)
public class ColorfulFlares {

    public static final String MOD_ID = "colorful_flares";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ColorfulFlares() {
        @SuppressWarnings("removal") IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AllItems.register(modEventBus);
        AllEntities.register(modEventBus);
        AllBlocks.register(modEventBus);
        AllParticles.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(AllItems.WHITE_FLARE);
            event.accept(AllItems.LIGHT_GRAY_FLARE);
            event.accept(AllItems.RED_FLARE);
            event.accept(AllItems.ORANGE_FLARE);
            event.accept(AllItems.YELLOW_FLARE);
            event.accept(AllItems.LIME_FLARE);
            event.accept(AllItems.GREEN_FLARE);
            event.accept(AllItems.CYAN_FLARE);
            event.accept(AllItems.LIGHT_BLUE_FLARE);
            event.accept(AllItems.BLUE_FLARE);
            event.accept(AllItems.PURPLE_FLARE);
            event.accept(AllItems.MAGENTA_FLARE);
            event.accept(AllItems.PINK_FLARE);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Register EntityRenderers
            EntityRenderers.register(AllEntities.FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.WHITE_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.LIGHT_GRAY_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.RED_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.ORANGE_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.YELLOW_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.LIME_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.GREEN_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.CYAN_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.LIGHT_BLUE_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.BLUE_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.PURPLE_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.MAGENTA_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(AllEntities.PINK_FLARE_PROJECTILE.get(), ThrownItemRenderer::new);
        }

        @SubscribeEvent
        public static void registerParticles(RegisterParticleProvidersEvent event) {
            // Smoke color types:
            // WHITE, LIGHT_GRAY, RED, ORANGE, YELLOW, LIME, GREEN, CYAN, LIGHT_BLUE, BLUE, PURPLE, MAGENTA, PINK
            event.registerSpriteSet(AllParticles.WHITE_FLARE_SMOKE.get(), FlareSmoke.WhiteFactory::new);
            event.registerSpriteSet(AllParticles.LIGHT_GRAY_FLARE_SMOKE.get(), FlareSmoke.LightGrayFactory::new);
            event.registerSpriteSet(AllParticles.RED_FLARE_SMOKE.get(), FlareSmoke.RedFactory::new);
            event.registerSpriteSet(AllParticles.ORANGE_FLARE_SMOKE.get(), FlareSmoke.OrangeFactory::new);
            event.registerSpriteSet(AllParticles.YELLOW_FLARE_SMOKE.get(), FlareSmoke.YellowFactory::new);
            event.registerSpriteSet(AllParticles.LIME_FLARE_SMOKE.get(), FlareSmoke.LimeFactory::new);
            event.registerSpriteSet(AllParticles.GREEN_FLARE_SMOKE.get(), FlareSmoke.GreenFactory::new);
            event.registerSpriteSet(AllParticles.CYAN_FLARE_SMOKE.get(), FlareSmoke.CyanFactory::new);
            event.registerSpriteSet(AllParticles.LIGHT_BLUE_FLARE_SMOKE.get(), FlareSmoke.LightBlueFactory::new);
            event.registerSpriteSet(AllParticles.BLUE_FLARE_SMOKE.get(), FlareSmoke.BlueFactory::new);
            event.registerSpriteSet(AllParticles.PURPLE_FLARE_SMOKE.get(), FlareSmoke.PurpleFactory::new);
            event.registerSpriteSet(AllParticles.MAGENTA_FLARE_SMOKE.get(), FlareSmoke.MagentaFactory::new);
            event.registerSpriteSet(AllParticles.PINK_FLARE_SMOKE.get(), FlareSmoke.PinkFactory::new);
        }
    }
}
