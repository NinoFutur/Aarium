
package net.mcreator.aarium.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class AariumingotpaintingPainting extends AariumModElements.ModElement {
	public AariumingotpaintingPainting(AariumModElements instance) {
		super(instance, 138);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(256, 256).setRegistryName("aariumingotpainting"));
	}
}
