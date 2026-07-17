package dev.sharkengine.net;

import dev.sharkengine.SharkEngineMod;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/** Edge-triggered request to toggle the current pilot's ship anchor. */
public record AnchorToggleC2SPayload() implements CustomPacketPayload {
    public static final Type<AnchorToggleC2SPayload> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(SharkEngineMod.MOD_ID, "anchor_toggle"));

    public static final StreamCodec<RegistryFriendlyByteBuf, AnchorToggleC2SPayload> CODEC =
            StreamCodec.of(AnchorToggleC2SPayload::write, AnchorToggleC2SPayload::read);

    private static void write(RegistryFriendlyByteBuf buf, AnchorToggleC2SPayload payload) {
        // No body: receipt of this edge-triggered packet is the action.
    }

    private static AnchorToggleC2SPayload read(RegistryFriendlyByteBuf buf) {
        return new AnchorToggleC2SPayload();
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
