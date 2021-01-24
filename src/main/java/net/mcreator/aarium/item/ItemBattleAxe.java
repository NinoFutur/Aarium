
package net.mcreator.aarium.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Blocks;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.aarium.ElementsAariumMod;

import com.google.common.collect.Multimap;

@ElementsAariumMod.ModElement.Tag
public class ItemBattleAxe extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:battle_axe")
	public static final Item block = null;
	public ItemBattleAxe(ElementsAariumMod instance) {
		super(instance, 98);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
		}.setUnlocalizedName("battle_axe").setRegistryName("battle_axe").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:battle_axe", "inventory"));
	}
	private static class ItemToolCustom extends Item {
		protected ItemToolCustom() {
			setMaxDamage(1500);
			setMaxStackSize(1);
		}

		@Override
		public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
			Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
			if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 5f, 0));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", 1, 0));
			}
			return multimap;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			IBlockState require;
			require = Blocks.SAPLING.getStateFromMeta(0);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 7f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 7f;
			}
			require = Blocks.SAPLING.getStateFromMeta(1);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 7f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 7f;
			}
			require = Blocks.SAPLING.getStateFromMeta(2);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 7f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 7f;
			}
			require = Blocks.SAPLING.getStateFromMeta(3);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 7f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 7f;
			}
			require = Blocks.SAPLING.getStateFromMeta(4);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 7f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 7f;
			}
			require = Blocks.SAPLING.getStateFromMeta(5);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 7f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 7f;
			}
			require = Blocks.REEDS.getDefaultState();
			if (par2Block.getBlock() == require.getBlock())
				return 7f;
			return 0;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
			stack.damageItem(1, entityLiving);
			return true;
		}

		@Override
		public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
			stack.damageItem(2, attacker);
			return true;
		}

		@Override
		public boolean isFull3D() {
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 20;
		}
	}
}
