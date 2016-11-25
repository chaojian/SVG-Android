package com.android.svg.support.svgnew.parser;

import com.android.svg.support.svgnew.model.Circle;
import com.android.svg.support.svgnew.model.Ellipse;
import com.android.svg.support.svgnew.model.G;
import com.android.svg.support.svgnew.model.Line;
import com.android.svg.support.svgnew.model.Path;
import com.android.svg.support.svgnew.model.Polygon;
import com.android.svg.support.svgnew.model.Rect;
import com.android.svg.support.svgnew.model.Svg;
import com.android.svg.support.svgnew.model.SvgConstants;
import com.android.svg.support.xml.ChildrenElementParser;

import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * Parse the svg's root element.
 *
 * @author Megatron King
 * @since 2016/11/22 18:12
 */

public class SvgElementParser extends ChildrenElementParser<Svg> {

    public SvgElementParser() {
        super(SvgParserImpl.SVG_ATTRIBUTE_PARSER);
    }

    @Override
    public void parse(Element element, Svg svg) throws DocumentException {
        super.parse(element, svg);
        // Apply styles from the root node of svg tree, until all leaf nodes was traversed.
        svg.applyStyles(null);
        // Transform from the root node of svg tree, until all leaf nodes was traversed.
        svg.transform(1.0f, 0, 0, 1.0f, 0, 0);
    }

    @Override
    protected void parseChild(Element childElement, Svg svg) throws DocumentException {
        if (SvgConstants.TAG_GROUP.equals(childElement.getName())) {
            G group = new G();
            svg.children.add(group);
            SvgParserImpl.G_ELEMENT_PARSER.parse(childElement, group);
        }
        if (SvgConstants.TAG_CIRCLE.equals(childElement.getName())) {
            Circle circle = new Circle();
            svg.children.add(circle);
            SvgParserImpl.CIRCLE_ATTRIBUTE_PARSER.parse(childElement, circle);
        }
        if (SvgConstants.TAG_ELLIPSE.equals(childElement.getName())) {
            Ellipse ellipse = new Ellipse();
            svg.children.add(ellipse);
            SvgParserImpl.ELLIPSE_ATTRIBUTE_PARSER.parse(childElement, ellipse);
        }
        if (SvgConstants.TAG_LINE.equals(childElement.getName())) {
            Line line = new Line();
            svg.children.add(line);
            SvgParserImpl.LINE_ATTRIBUTE_PARSER.parse(childElement, line);
        }
        if (SvgConstants.TAG_RECT.equals(childElement.getName())) {
            Rect rect = new Rect();
            svg.children.add(rect);
            SvgParserImpl.RECT_ATTRIBUTE_PARSER.parse(childElement, rect);
        }
        if (SvgConstants.TAG_POLYGON.equals(childElement.getName())) {
            Polygon polygon = new Polygon();
            svg.children.add(polygon);
            SvgParserImpl.POLYGON_ATTRIBUTE_PARSER.parse(childElement, polygon);
        }
        if (SvgConstants.TAG_PATH.equals(childElement.getName())) {
            Path path = new Path();
            svg.children.add(path);
            SvgParserImpl.PATH_ATTRIBUTE_PARSER.parse(childElement, path);
        }
    }
}
