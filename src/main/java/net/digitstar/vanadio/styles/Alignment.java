/*
 * Copyright 2010 DiGiTsTar.NeT (dTs)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package net.digitstar.vanadio.styles;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class Alignment
{
	private CellStyle.Align horizAlign;
	private CellStyle.Align vertAlign;
	private boolean converted;


	public Alignment(Alignment align)
	{
		if(align != null)
		{
			init(align.getHorizAlign(), align.getVertAlign());
		}

	}

	public Alignment(CellStyle.Align horizontal, CellStyle.Align vertical)
	{
		init(horizontal, vertical);
	}

	public CellStyle.Align getHorizAlign()
	{
		return horizAlign;
	}

	public void setHorizAlign(CellStyle.Align horizAlign)
	{
		this.horizAlign = horizAlign;
	}

	public CellStyle.Align getVertAlign()
	{
		return vertAlign;
	}

	public void setVertAlign(CellStyle.Align vertAlign)
	{
		this.vertAlign = vertAlign;
	}

	public Alignment convert(CellStyle.Rotation rotation)
	{
		if(!this.converted)
		{

			if(rotation == CellStyle.Rotation.VERTICAL_UP)
			{
				if(horizAlign == CellStyle.Align.LEFT && vertAlign == CellStyle.Align.BOTTOM)
				{
					this.setHorizAlign(CellStyle.Align.LEFT);
					this.setVertAlign(CellStyle.Align.TOP);
				} else if(horizAlign == CellStyle.Align.LEFT && vertAlign == CellStyle.Align.MIDDLE)
				{
					this.setHorizAlign(CellStyle.Align.CENTER);
					this.setVertAlign(CellStyle.Align.TOP);
				} else if(horizAlign == CellStyle.Align.LEFT && vertAlign == CellStyle.Align.TOP)
				{
					this.setHorizAlign(CellStyle.Align.RIGHT);
					this.setVertAlign(CellStyle.Align.TOP);
				} else if(horizAlign == CellStyle.Align.CENTER && vertAlign == CellStyle.Align.BOTTOM)
				{
					this.setHorizAlign(CellStyle.Align.LEFT);
					this.setVertAlign(CellStyle.Align.MIDDLE);
				} else if(horizAlign == CellStyle.Align.CENTER && vertAlign == CellStyle.Align.MIDDLE)
				{
					this.setHorizAlign(CellStyle.Align.CENTER);
					this.setVertAlign(CellStyle.Align.MIDDLE);
				} else if(horizAlign == CellStyle.Align.CENTER && vertAlign == CellStyle.Align.TOP)
				{
					this.setHorizAlign(CellStyle.Align.RIGHT);
					this.setVertAlign(CellStyle.Align.MIDDLE);
				} else if(horizAlign == CellStyle.Align.RIGHT && vertAlign == CellStyle.Align.BOTTOM)
				{
					this.setHorizAlign(CellStyle.Align.LEFT);
					this.setVertAlign(CellStyle.Align.BOTTOM);
				} else if(horizAlign == CellStyle.Align.RIGHT && vertAlign == CellStyle.Align.MIDDLE)
				{
					this.setHorizAlign(CellStyle.Align.CENTER);
					this.setVertAlign(CellStyle.Align.BOTTOM);
				} else if(horizAlign == CellStyle.Align.RIGHT && vertAlign == CellStyle.Align.TOP)
				{
					this.setHorizAlign(CellStyle.Align.RIGHT);
					this.setVertAlign(CellStyle.Align.BOTTOM);
				}

			} else if(rotation == CellStyle.Rotation.UPSIDE)
			{
				if(horizAlign == CellStyle.Align.LEFT && vertAlign == CellStyle.Align.BOTTOM)
				{
					this.setHorizAlign(CellStyle.Align.RIGHT);
					this.setVertAlign(CellStyle.Align.TOP);
				} else if(horizAlign == CellStyle.Align.LEFT && vertAlign == CellStyle.Align.MIDDLE)
				{
					this.setHorizAlign(CellStyle.Align.RIGHT);
					this.setVertAlign(CellStyle.Align.MIDDLE);
				} else if(horizAlign == CellStyle.Align.LEFT && vertAlign == CellStyle.Align.TOP)
				{
					this.setHorizAlign(CellStyle.Align.RIGHT);
					this.setVertAlign(CellStyle.Align.BOTTOM);
				} else if(horizAlign == CellStyle.Align.CENTER && vertAlign == CellStyle.Align.BOTTOM)
				{
					this.setHorizAlign(CellStyle.Align.CENTER);
					this.setVertAlign(CellStyle.Align.TOP);
				} else if(horizAlign == CellStyle.Align.CENTER && vertAlign == CellStyle.Align.MIDDLE)
				{
					this.setHorizAlign(CellStyle.Align.CENTER);
					this.setVertAlign(CellStyle.Align.MIDDLE);
				} else if(horizAlign == CellStyle.Align.CENTER && vertAlign == CellStyle.Align.TOP)
				{
					this.setHorizAlign(CellStyle.Align.CENTER);
					this.setVertAlign(CellStyle.Align.BOTTOM);
				} else if(horizAlign == CellStyle.Align.RIGHT && vertAlign == CellStyle.Align.BOTTOM)
				{
					this.setHorizAlign(CellStyle.Align.LEFT);
					this.setVertAlign(CellStyle.Align.TOP);
				} else if(horizAlign == CellStyle.Align.RIGHT && vertAlign == CellStyle.Align.MIDDLE)
				{
					this.setHorizAlign(CellStyle.Align.LEFT);
					this.setVertAlign(CellStyle.Align.MIDDLE);
				} else if(horizAlign == CellStyle.Align.RIGHT && vertAlign == CellStyle.Align.TOP)
				{
					this.setHorizAlign(CellStyle.Align.LEFT);
					this.setVertAlign(CellStyle.Align.BOTTOM);
				}
			} else if(rotation == CellStyle.Rotation.VERTICAL_DOWN)
			{
				if(horizAlign == CellStyle.Align.LEFT && vertAlign == CellStyle.Align.BOTTOM)
				{
					this.setHorizAlign(CellStyle.Align.RIGHT);
					this.setVertAlign(CellStyle.Align.BOTTOM);
				} else if(horizAlign == CellStyle.Align.LEFT && vertAlign == CellStyle.Align.MIDDLE)
				{
					this.setHorizAlign(CellStyle.Align.CENTER);
					this.setVertAlign(CellStyle.Align.BOTTOM);
				} else if(horizAlign == CellStyle.Align.LEFT && vertAlign == CellStyle.Align.TOP)
				{
					this.setHorizAlign(CellStyle.Align.LEFT);
					this.setVertAlign(CellStyle.Align.BOTTOM);
				} else if(horizAlign == CellStyle.Align.CENTER && vertAlign == CellStyle.Align.BOTTOM)
				{
					this.setHorizAlign(CellStyle.Align.RIGHT);
					this.setVertAlign(CellStyle.Align.MIDDLE);
				} else if(horizAlign == CellStyle.Align.CENTER && vertAlign == CellStyle.Align.MIDDLE)
				{
					this.setHorizAlign(CellStyle.Align.CENTER);
					this.setVertAlign(CellStyle.Align.MIDDLE);
				} else if(horizAlign == CellStyle.Align.CENTER && vertAlign == CellStyle.Align.TOP)
				{
					this.setHorizAlign(CellStyle.Align.LEFT);
					this.setVertAlign(CellStyle.Align.MIDDLE);
				} else if(horizAlign == CellStyle.Align.RIGHT && vertAlign == CellStyle.Align.BOTTOM)
				{
					this.setHorizAlign(CellStyle.Align.RIGHT);
					this.setVertAlign(CellStyle.Align.TOP);
				} else if(horizAlign == CellStyle.Align.RIGHT && vertAlign == CellStyle.Align.MIDDLE)
				{
					this.setHorizAlign(CellStyle.Align.CENTER);
					this.setVertAlign(CellStyle.Align.TOP);
				} else if(horizAlign == CellStyle.Align.RIGHT && vertAlign == CellStyle.Align.TOP)
				{
					this.setHorizAlign(CellStyle.Align.LEFT);
					this.setVertAlign(CellStyle.Align.TOP);
				}

			} else
			{
				/* Caso rotation = Rotation.NONE ritorna gli stessi invariati */
			}
			this.converted = true;
		}
		return this;
	}

	public void resetConverted()
	{
		this.converted = false;
	}

	public void setConverted()
	{
		this.converted = true;
	}

	public static CellStyle assign(CellStyle style)
	{
		if(style != null)
		{
			Alignment align = style.getAlignment();
			align.setHorizAlign(style.getHorizAlign());
			align.setVertAlign(style.getVertAlign());
			align.convert(style.getRotation());
			style.setHorizAlign(align.getHorizAlign());
			style.setVertAlign(align.getVertAlign());
			style.getAlignment().setConverted();
		}
		return style;
	}

	private void init(CellStyle.Align horizontal, CellStyle.Align vertical)
	{
		this.horizAlign = horizontal;
		this.vertAlign = vertical;
		this.converted = false;

	}

}
