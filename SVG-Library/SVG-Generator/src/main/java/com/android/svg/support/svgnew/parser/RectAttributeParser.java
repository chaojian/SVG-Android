package com.android.svg.support.svgnew.parser;

import com.android.svg.support.svgnew.model.Rect;
import com.android.svg.support.svgnew.model.SvgConstants;
import com.android.svg.support.svgnew.utils.StyleUtils;
import com.android.svg.support.xml.CommonAbstractAttributeParser;

import org.dom4j.Element;

/**
 * Build rect's field values from attributes of the svg element.
 *
 * @author Megatron King
 * @since 2016/11/22 19:00
 */

public class RectAttributeParser extends CommonAbstractAttributeParser<Rect>{

    @Override
    public void parse(Element element, Rect rect) {
        rect.x = parseFloat(element, SvgConstants.ATTR_X);
        rect.y = parseFloat(element, SvgConstants.ATTR_Y);
        rect.width = parseFloat(element, SvgConstants.ATTR_WIDTH);
        rect.height = parseFloat(element, SvgConstants.ATTR_HEIGHT);
        rect.styleMaps = StyleUtils.convertStyleString2Map(parseString(element, SvgConstants.ATTR_STYLE));
        rect.toPath();
    }
}
