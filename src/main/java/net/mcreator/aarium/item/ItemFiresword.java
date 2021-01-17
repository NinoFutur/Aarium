
package net.mcreator.aarium.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.aarium.procedure.ProcedureFireswordLivingEntityIsHitWithTool2;
import net.mcreator.aarium.procedure.ProcedureFireswordLivingEntityIsHitWithTool;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import com.google.common.collect.Multimap;

@ElementsAariumMod.ModElement.Tag
public class ItemFiresword extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:firesword")
	public static final Item block = null;
	public ItemFiresword(ElementsAariumMod instance) {
		super(instance, 95);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSword(EnumHelper.addToolMaterial("FIRESWORD", 5, 1500, 12f, 5f, 10)) {
			@Override
			public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot slot) {
				Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);
				if (slot == EntityEquipmentSlot.MAINHAND) {
					multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
							new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.getAttackDamage(), 0));
					multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
							new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3.5, 0));
				}
				return multimap;
			}

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("sword", 5);
				return ret.keySet();
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ProcedureFireswordLivingEntityIsHitWithTool2.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public EnumActionResult onItemUse(EntityPlayer entity, World world, BlockPos pos, EnumHand hand, EnumFacing direction, float hitX,
					float hitY, float hitZ) {
				EnumActionResult retval = super.onItemUse(entity, world, pos, hand, direction, hitX, hitY, hitZ);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				ItemStack itemstack = entity.getHeldItem(hand);
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ProcedureFireswordLivingEntityIsHitWithTool2.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, EntityLivingBase entity, EntityLivingBase entity2) {
				super.hitEntity(itemstack, entity, entity2);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureFireswordLivingEntityIsHitWithTool.executeProcedure($_dependencies);
				}
				return true;
			}
		}.setUnlocalizedName("firesword").setRegistryName("firesword").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:firesword", "inventory"));
	}
}
