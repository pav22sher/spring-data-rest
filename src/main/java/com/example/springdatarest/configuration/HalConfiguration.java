package com.example.springdatarest.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;

import java.util.Collection;

@Configuration
public class HalConfiguration {
    @Bean
    public Jackson2HalModule replacementInHalModuleModelClassOnModelMixinClass() {
        Jackson2HalModule halModule = new Jackson2HalModule();
        halModule.setMixInAnnotation(RepresentationModel.class, CustomRepresentationModelMixin.class);
        halModule.setMixInAnnotation(CollectionModel.class, CustomCollectionModelMixin.class);
        return halModule;
    }

    @JsonIgnoreProperties(value = {"_links"})
    public abstract static class CustomRepresentationModelMixin extends RepresentationModel<CustomRepresentationModelMixin> {

        @Override
        @JsonIgnore
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonSerialize(using = Jackson2HalModule.HalLinkListSerializer.class)
        @JsonDeserialize(using = Jackson2HalModule.HalLinkListDeserializer.class)
        public abstract Links getLinks();

    }


    @JsonIgnoreProperties(value = {"_links"})
    public abstract static class CustomCollectionModelMixin<T> extends CollectionModel<T> {

        @Override
        @JsonValue
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonSerialize(using = Jackson2HalModule.HalResourcesSerializer.class)
        @JsonDeserialize(using = Jackson2HalModule.HalResourcesDeserializer.class)
        public abstract Collection<T> getContent();

    }
}
