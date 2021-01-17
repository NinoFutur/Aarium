
package net.mcreator.aarium.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.Block;

import net.mcreator.aarium.world.WorldSpawn;
import net.mcreator.aarium.world.WorldSolitudia;
import net.mcreator.aarium.world.WorldSkyaria;
import net.mcreator.aarium.world.WorldSiberia;
import net.mcreator.aarium.world.WorldPateria;
import net.mcreator.aarium.world.WorldIgnisia;
import net.mcreator.aarium.world.WorldForestia;
import net.mcreator.aarium.world.WorldFarmingwood;
import net.mcreator.aarium.world.WorldFarmingstone;
import net.mcreator.aarium.world.WorldFarmingobsidian;
import net.mcreator.aarium.world.WorldFarmingdirt;
import net.mcreator.aarium.world.WorldEvent;
import net.mcreator.aarium.world.WorldAquaria;
import net.mcreator.aarium.procedure.ProcedurePoisonousMushroomEntityCollidesInTheBlock;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@ElementsAariumMod.ModElement.Tag
public class BlockPoisonousMushroom extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:poisonous_mushroom")
	public static final Block block = null;
	public BlockPoisonousMushroom(ElementsAariumMod instance) {
		super(instance, 119);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:poisonous_mushroom", "inventory"));
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == 0)
			dimensionCriteria = true;
		if (dimID == WorldSpawn.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldEvent.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingwood.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingstone.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingdirt.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingobsidian.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldAquaria.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldSiberia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldPateria.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldForestia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldSolitudia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldIgnisia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldSkyaria.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("forest")))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		for (int i = 0; i < 1; i++) {
			int l6 = chunkX + random.nextInt(16) + 8;
			int i11 = random.nextInt(128);
			int l14 = chunkZ + random.nextInt(16) + 8;
			(new WorldGenFlowers(((BlockFlower) block), BlockFlower.EnumFlowerType.DANDELION)).generate(world, random, new BlockPos(l6, i11, l14));
		}
	}
	public static class BlockCustomFlower extends BlockFlower {
		public BlockCustomFlower() {
			setSoundType(SoundType.PLANT);
			setCreativeTab(CreativeTabs.DECORATIONS);
			setHardness(0F);
			setResistance(0F);
			setLightLevel(0F);
			setUnlocalizedName("poisonous_mushroom");
			setRegistryName("poisonous_mushroom");
		}

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 100;
		}

		@Override
		public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 60;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(this));
		}

		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(Item.getItemFromBlock(this), 1, this.damageDropped(state));
		}

		@Override
		public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
			return EnumPlantType.Plains;
		}

		@Override
		public BlockFlower.EnumFlowerColor getBlockType() {
			return BlockFlower.EnumFlowerColor.YELLOW;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void getSubBlocks(CreativeTabs tab, net.minecraft.util.NonNullList<ItemStack> list) {
			for (BlockFlower.EnumFlowerType blockflower$enumflowertype : BlockFlower.EnumFlowerType.getTypes(this.getBlockType())) {
				list.add(new ItemStack(this, 1, blockflower$enumflowertype.getMeta()));
			}
		}

		@Override
		public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
			super.onEntityCollidedWithBlock(world, pos, state, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedurePoisonousMushroomEntityCollidesInTheBlock.executeProcedure($_dependencies);
			}
		}
	}
}
