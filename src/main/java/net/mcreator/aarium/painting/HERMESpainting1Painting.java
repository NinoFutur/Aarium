
package net.mcreator.aarium.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class HERMESpainting1Painting extends AariumModElements.ModElement {
	public HERMESpainting1Painting(AariumModElements instance) {
		super(instance, 141);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 64).setRegistryName("herme_spainting_1"));
	}
}
