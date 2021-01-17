
package net.mcreator.aarium.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class EntityKoro extends ElementsAariumMod.ModElement {
	public static final int ENTITYID = 2;
	public static final int ENTITYID_RANGED = 3;
	public EntityKoro(ElementsAariumMod instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("aarium", "koro"), ENTITYID)
				.name("koro").tracker(64, 3, true).egg(-1, 1358912768).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("forest")),};
		EntityRegistry.addSpawn(EntityCustom.class, 30, 2, 60, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelcustom_model(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aarium:textures/oak_log.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityAnimal {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAITempt(this, 1, new ItemStack(Blocks.SAPLING, (int) (1), 0).getItem(), false));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Blocks.LOG, (int) (1), 0).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof EntityPotion)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.9D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0D);
		}

		@Override
		public EntityCustom createChild(EntityAgeable ageable) {
			return new EntityCustom(world);
		}

		@Override
		public float getEyeHeight() {
			return this.isChild() ? this.height : 1.3F;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(Blocks.SAPLING, (int) (1), 0).getItem() == stack.getItem()
					&& new ItemStack(Blocks.SAPLING, (int) (1), 0).getMetadata() == stack.getMetadata())
				return true;
			return false;
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends ModelBase {
		private final ModelRenderer bb_main;
		private final ModelRenderer Rightarm_r1;
		public Modelcustom_model() {
			textureWidth = 16;
			textureHeight = 16;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -3.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -3.0F, -10.0F, -2.0F, 6, 7, 4, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -2.0F, -14.0F, -2.0F, 4, 4, 4, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 3.0F, -9.0F, 0.0F, 1, 5, 1, 0.0F, false));
			Rightarm_r1 = new ModelRenderer(this);
			Rightarm_r1.setRotationPoint(-3.0F, 0.0F, -3.0F);
			bb_main.addChild(Rightarm_r1);
			setRotationAngle(Rightarm_r1, 0.0F, -1.5708F, 0.0F);
			Rightarm_r1.cubeList.add(new ModelBox(Rightarm_r1, 0, 0, 3.0F, -9.0F, 0.0F, 1, 5, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bb_main.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		}
	}
}
