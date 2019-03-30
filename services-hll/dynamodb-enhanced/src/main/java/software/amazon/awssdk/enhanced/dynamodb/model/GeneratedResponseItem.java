package software.amazon.awssdk.enhanced.dynamodb.model;

import java.util.Collection;
import java.util.Map;
import software.amazon.awssdk.annotations.SdkPublicApi;
import software.amazon.awssdk.annotations.ThreadSafe;
import software.amazon.awssdk.enhanced.dynamodb.converter.ItemAttributeValueConverter;
import software.amazon.awssdk.enhanced.dynamodb.internal.model.DefaultGeneratedResponseItem;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

@SdkPublicApi
@ThreadSafe
public interface GeneratedResponseItem extends AttributeAware<AttributeValue>,
                                               ConverterAware,
                                               ToCopyableBuilder<GeneratedResponseItem.Builder, GeneratedResponseItem> {
    static GeneratedResponseItem.Builder builder() {
        return DefaultGeneratedResponseItem.builder();
    }

    ResponseItem toResponseItem();

    interface Builder extends AttributeAware.Builder<AttributeValue>,
                              ConverterAware.Builder ,
                              CopyableBuilder<Builder, GeneratedResponseItem> {
        @Override
        Builder putAttributes(Map<String, AttributeValue> attributeValues);

        @Override
        Builder putAttribute(String attributeKey, AttributeValue attributeValue);

        @Override
        Builder removeAttribute(String attributeKey);

        @Override
        Builder clearAttributes();

        @Override
        Builder addConverters(Collection<? extends ItemAttributeValueConverter> converters);

        @Override
        Builder addConverter(ItemAttributeValueConverter converter);

        @Override
        Builder clearConverters();

        GeneratedResponseItem build();
    }
}