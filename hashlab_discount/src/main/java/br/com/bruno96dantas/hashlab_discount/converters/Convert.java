package br.com.bruno96dantas.hashlab_discount.converters;

public interface Convert<model, dto> {

    model convert(dto objectDto);

    dto unConvert(model objectModel);
}
