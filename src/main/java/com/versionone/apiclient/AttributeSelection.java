package com.versionone.apiclient;

import java.util.ArrayList;
import java.util.List;

import com.versionone.apiclient.interfaces.IAttributeDefinition;
import com.versionone.apiclient.services.TextBuilder;

/**
 * Attributes being selected in a Query
 */
public class AttributeSelection extends ArrayList<IAttributeDefinition> {
	private static final long serialVersionUID = 1L;

	public static AttributeSelection merge(List<IAttributeDefinition>... lists){
		AttributeSelection result = new AttributeSelection();
		for(List<IAttributeDefinition> list : lists){
			for(IAttributeDefinition def : list){
				if (!result.contains(def)){
					result.add(def);
				}
			}
		}
		return result;
	}

	/**
	 * Get a comma separated string of the names of all the attributes being selected
	 * 
	 * @return String
	 */
	public String getNames() {
		return TextBuilder.join(toArray(), ",", TextBuilder.STRINGIZER_DELEGATE.build(AttributeSelection.class, "NameOf"));
	}

	/**
	 * Get a comma separated string of the names of all the attributes being selected
	 * 
	 * @return String
	 */
	public String getToken() {
		return TextBuilder.join(toArray(), ",", TextBuilder.STRINGIZER_DELEGATE.build(AttributeSelection.class, "TokenOf"));
	}

	/**
	 * Implementation detail.  Returns the Token of the attribute definition
	 * 
	 * @param def - Object
	 * @return String
	 */
	public static String TokenOf(Object def)
	{
		return ((IAttributeDefinition)def).getToken();
	}

	/**
	 * Implementation detail.  Returns the Name of the attribute definition
	 * 
	 * @param def - Object
	 * @return String
	 */
	public static String NameOf(Object def)
	{
		return ((IAttributeDefinition) def).getName();
	}
}
