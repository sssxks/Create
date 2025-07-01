package com.simibubi.create.content.logistics.tableCloth;

import com.simibubi.create.AllPackets;
import com.simibubi.create.foundation.blockEntity.SyncedBlockEntity;
import com.simibubi.create.foundation.networking.BlockEntityDataPacket;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.createmod.catnip.net.base.ClientboundPacketPayload;

public class ShopUpdatePacket extends BlockEntityDataPacket<TableClothBlockEntity> implements ClientboundPacketPayload {

	public static final StreamCodec<RegistryFriendlyByteBuf, ShopUpdatePacket> STREAM_CODEC = StreamCodec.ofMember(
		ShopUpdatePacket::writeData, ShopUpdatePacket::new
	);

	public ShopUpdatePacket(BlockPos pos) {
		super(pos);
	}

	public ShopUpdatePacket(FriendlyByteBuf buffer) {
		super(buffer);
	}

	@Override
	protected void writeData(FriendlyByteBuf buffer) {
	}

	@Override
	protected void handlePacket(TableClothBlockEntity be) {
		if (!be.hasLevel()) {
			return;
		}

		be.invalidateItemsForRender();
	}

	@Override
	public PacketTypeProvider getTypeProvider() {
		return AllPackets.SHOP_UPDATE;
	}
}
