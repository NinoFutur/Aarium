
package net.mcreator.aarium.gui;

@ElementsAariumMod.ModElement.Tag
public class GuiInfinitecobblestonegeneratorgui extends ElementsAariumMod.ModElement {

	public static int GUIID = 7;
	public static HashMap guistate = new HashMap();

	public GuiInfinitecobblestonegeneratorgui(ElementsAariumMod instance) {
		super(instance, 322);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		elements.addNetworkMessage(GUIButtonPressedMessageHandler.class, GUIButtonPressedMessage.class, Side.SERVER);
		elements.addNetworkMessage(GUISlotChangedMessageHandler.class, GUISlotChangedMessage.class, Side.SERVER);
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {

		private IInventory internal;

		private World world;
		private EntityPlayer entity;
		private int x, y, z;

		private Map<Integer, Slot> customSlots = new HashMap<>();

		public GuiContainerMod(World world, int x, int y, int z, EntityPlayer player) {
			this.world = world;
			this.entity = player;
			this.x = x;
			this.y = y;
			this.z = z;

			this.internal = new InventoryBasic("", true, 9);

			TileEntity ent = world.getTileEntity(new BlockPos(x, y, z));
			if (ent instanceof IInventory)
				this.internal = (IInventory) ent;

			this.customSlots.put(0, this.addSlotToContainer(new Slot(internal, 0, 7, 44) {

				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					GuiContainerMod.this.slotChanged(0, 0, 0);
				}

				@Override
				public ItemStack onTake(EntityPlayer entity, ItemStack stack) {
					ItemStack retval = super.onTake(entity, stack);
					GuiContainerMod.this.slotChanged(0, 1, 0);
					return retval;
				}

				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(0, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(1, this.addSlotToContainer(new Slot(internal, 1, 25, 44) {

				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					GuiContainerMod.this.slotChanged(1, 0, 0);
				}

				@Override
				public ItemStack onTake(EntityPlayer entity, ItemStack stack) {
					ItemStack retval = super.onTake(entity, stack);
					GuiContainerMod.this.slotChanged(1, 1, 0);
					return retval;
				}

				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(1, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(2, this.addSlotToContainer(new Slot(internal, 2, 43, 44) {

				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					GuiContainerMod.this.slotChanged(2, 0, 0);
				}

				@Override
				public ItemStack onTake(EntityPlayer entity, ItemStack stack) {
					ItemStack retval = super.onTake(entity, stack);
					GuiContainerMod.this.slotChanged(2, 1, 0);
					return retval;
				}

				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(2, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(3, this.addSlotToContainer(new Slot(internal, 3, 61, 44) {

				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					GuiContainerMod.this.slotChanged(3, 0, 0);
				}

				@Override
				public ItemStack onTake(EntityPlayer entity, ItemStack stack) {
					ItemStack retval = super.onTake(entity, stack);
					GuiContainerMod.this.slotChanged(3, 1, 0);
					return retval;
				}

				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(3, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(4, this.addSlotToContainer(new Slot(internal, 4, 79, 44) {

				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					GuiContainerMod.this.slotChanged(4, 0, 0);
				}

				@Override
				public ItemStack onTake(EntityPlayer entity, ItemStack stack) {
					ItemStack retval = super.onTake(entity, stack);
					GuiContainerMod.this.slotChanged(4, 1, 0);
					return retval;
				}

				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(4, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(5, this.addSlotToContainer(new Slot(internal, 5, 97, 44) {

				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					GuiContainerMod.this.slotChanged(5, 0, 0);
				}

				@Override
				public ItemStack onTake(EntityPlayer entity, ItemStack stack) {
					ItemStack retval = super.onTake(entity, stack);
					GuiContainerMod.this.slotChanged(5, 1, 0);
					return retval;
				}

				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(5, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(6, this.addSlotToContainer(new Slot(internal, 6, 115, 44) {

				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					GuiContainerMod.this.slotChanged(6, 0, 0);
				}

				@Override
				public ItemStack onTake(EntityPlayer entity, ItemStack stack) {
					ItemStack retval = super.onTake(entity, stack);
					GuiContainerMod.this.slotChanged(6, 1, 0);
					return retval;
				}

				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(6, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(7, this.addSlotToContainer(new Slot(internal, 7, 133, 44) {

				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					GuiContainerMod.this.slotChanged(7, 0, 0);
				}

				@Override
				public ItemStack onTake(EntityPlayer entity, ItemStack stack) {
					ItemStack retval = super.onTake(entity, stack);
					GuiContainerMod.this.slotChanged(7, 1, 0);
					return retval;
				}

				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(7, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(8, this.addSlotToContainer(new Slot(internal, 8, 151, 44) {

				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					GuiContainerMod.this.slotChanged(8, 0, 0);
				}

				@Override
				public ItemStack onTake(EntityPlayer entity, ItemStack stack) {
					ItemStack retval = super.onTake(entity, stack);
					GuiContainerMod.this.slotChanged(8, 1, 0);
					return retval;
				}

				@Override
				public void onSlotChange(ItemStack a, ItemStack b) {
					super.onSlotChange(a, b);
					GuiContainerMod.this.slotChanged(8, 2, b.getCount() - a.getCount());
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));

			int si;
			int sj;

			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlotToContainer(new Slot(player.inventory, sj + (si + 1) * 9, 0 + 8 + sj * 18, 0 + 84 + si * 18));

			for (si = 0; si < 9; ++si)
				this.addSlotToContainer(new Slot(player.inventory, si, 0 + 8 + si * 18, 0 + 142));

		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return internal.isUsableByPlayer(player);
		}

		@Override
		public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot) this.inventorySlots.get(index);

			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();

				if (index < 9) {
					if (!this.mergeItemStack(itemstack1, 9, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
					slot.onSlotChange(itemstack1, itemstack);
				} else if (!this.mergeItemStack(itemstack1, 0, 9, false)) {
					if (index < 9 + 27) {
						if (!this.mergeItemStack(itemstack1, 9 + 27, this.inventorySlots.size(), true)) {
							return ItemStack.EMPTY;
						}
					} else {
						if (!this.mergeItemStack(itemstack1, 9, 9 + 27, false)) {
							return ItemStack.EMPTY;
						}
					}
					return ItemStack.EMPTY;
				}

				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}

				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}

				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		@Override /* failed to load code for net.minecraft.inventory.Container */

		@Override
		public void onContainerClosed(EntityPlayer playerIn) {
			super.onContainerClosed(playerIn);
			if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
				this.clearContainer(playerIn, playerIn.world, internal);
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				AariumMod.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}

	}

	public static class GuiWindow extends GuiContainer {

		private World world;
		private int x, y, z;
		private EntityPlayer entity;

		public GuiWindow(World world, int x, int y, int z, EntityPlayer entity) {
			super(new GuiContainerMod(world, x, y, z, entity));
			this.world = world;
			this.x = x;
			this.y = y;
			this.z = z;
			this.entity = entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		private static final ResourceLocation texture = new ResourceLocation("aarium:textures/infinitecobblestonegeneratorgui.png");

		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
			this.drawDefaultBackground();
			super.drawScreen(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);

			this.mc.renderEngine.bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.drawModalRectWithCustomSizedTexture(k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

			zLevel = 100.0F;

		}

		@Override
		public void updateScreen() {
			super.updateScreen();
		}

		@Override
		protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {

			super.mouseClicked(mouseX, mouseY, mouseButton);
		}

		@Override
		protected void keyTyped(char typedChar, int keyCode) throws IOException {
			super.keyTyped(typedChar, keyCode);
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		}

		@Override
		public void onGuiClosed() {
			super.onGuiClosed();
			Keyboard.enableRepeatEvents(false);
		}

		@Override
		public void initGui() {
			super.initGui();

			this.guiLeft = (this.width - 176) / 2;
			this.guiTop = (this.height - 166) / 2;

			Keyboard.enableRepeatEvents(true);

			this.buttonList.clear();

		}

		@Override
		protected void actionPerformed(GuiButton button) {
			AariumMod.PACKET_HANDLER.sendToServer(new GUIButtonPressedMessage(button.id, x, y, z));
			handleButtonAction(entity, button.id, x, y, z);
		}

		@Override
		public boolean doesGuiPauseGame() {
			return false;
		}

	}

	public static class GUIButtonPressedMessageHandler implements IMessageHandler<GUIButtonPressedMessage, IMessage> {

		@Override
		public IMessage onMessage(GUIButtonPressedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;

				handleButtonAction(entity, buttonID, x, y, z);
			});
			return null;
		}
	}

	public static class GUISlotChangedMessageHandler implements IMessageHandler<GUISlotChangedMessage, IMessage> {

		@Override
		public IMessage onMessage(GUISlotChangedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;

				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			return null;
		}
	}

	public static class GUIButtonPressedMessage implements IMessage {

		int buttonID, x, y, z;

		public GUIButtonPressedMessage() {
		}

		public GUIButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(buttonID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			buttonID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
		}

	}

	public static class GUISlotChangedMessage implements IMessage {

		int slotID, x, y, z, changeType, meta;

		public GUISlotChangedMessage() {
		}

		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(slotID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
			buf.writeInt(changeType);
			buf.writeInt(meta);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			slotID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
			changeType = buf.readInt();
			meta = buf.readInt();
		}

	}

	private static void handleButtonAction(EntityPlayer entity, int buttonID, int x, int y, int z) {
		World world = entity.world;

		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;

	}

	private static void handleSlotAction(EntityPlayer entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;

		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;

		if (slotID == 0 && changeType == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 0 && changeType == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 0 && changeType == 2) {
			int amount = meta;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 1 && changeType == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 1 && changeType == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 1 && changeType == 2) {
			int amount = meta;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 2 && changeType == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 2 && changeType == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 2 && changeType == 2) {
			int amount = meta;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 3 && changeType == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 3 && changeType == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 3 && changeType == 2) {
			int amount = meta;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 4 && changeType == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 4 && changeType == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 4 && changeType == 2) {
			int amount = meta;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 5 && changeType == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 5 && changeType == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 5 && changeType == 2) {
			int amount = meta;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 6 && changeType == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 6 && changeType == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 6 && changeType == 2) {
			int amount = meta;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 7 && changeType == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 7 && changeType == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 7 && changeType == 2) {
			int amount = meta;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 8 && changeType == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 8 && changeType == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
		if (slotID == 8 && changeType == 2) {
			int amount = meta;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfinitecobblestonegeneratorguichangecontent.executeProcedure($_dependencies);
			}
		}
	}

}
