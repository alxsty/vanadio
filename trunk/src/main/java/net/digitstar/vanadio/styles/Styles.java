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

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;
import net.digitstar.vanadio.ReportOptions;


import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

import java.util.Locale;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */

public final class Styles
{
	public enum FontStyle
	{
		UNDEFINED(-1),
		NORMAL(0),
		BOLD(1),
		ITALIC(2),
		UNDERLINE(4),
		STRIKETHRU(8),
		BOLDITALIC(BOLD.getValue() | ITALIC.getValue());

		private int value = -1;

		FontStyle(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}
	}

	public enum FontFamily
	{
        UNDEFINED(-1, null),
        COURIER(0, BaseFont.COURIER),
        HELVETICA(1, BaseFont.HELVETICA),
        TIMES_ROMAN(2, BaseFont.TIMES_ROMAN),
        SYMBOL(3, BaseFont.SYMBOL),
        ZAPFDINGBATS(4, BaseFont.ZAPFDINGBATS),
        ARIAL(5, "Arial");

		private int value = -1;
		private String name = null;

		FontFamily(int value, String name)
		{
			this.value = value;
			this.name = name;
		}

		public int getValue()
		{
			return value;
		}

		public String getName()
		{
			return name;
		}

		public static FontFamily getDefaultFontFamily()
		{
            return FontFamily.ARIAL;
		}
	}

	public enum FontCharEncoding
	{
        CP1250("Cp1250"), // europa centrale
        CP1252("Cp1252"), // europa occidentale
		UTF8(BaseFont.IDENTITY_H);    // unicode

		private String name = null;

		FontCharEncoding(String name)
		{
			this.name = name;
		}


		public String getName()
		{
			return name;
		}

		public static FontCharEncoding getDefaultEncoding()
		{
            return FontCharEncoding.UTF8;
        }
	}


	public enum FontType
	{
        NORMAL(FontFamily.getDefaultFontFamily(), FontCharEncoding.getDefaultEncoding(), BaseFont.EMBEDDED, 7.0f, FontStyle.UNDEFINED, null),
        HEADERFOOTER(FontFamily.getDefaultFontFamily(), FontCharEncoding.getDefaultEncoding(), BaseFont.EMBEDDED, 6.0f, FontStyle.UNDEFINED, null),
		TOTAL(FontFamily.getDefaultFontFamily(), FontCharEncoding.getDefaultEncoding(), BaseFont.EMBEDDED, 7.0f, FontStyle.BOLD, null),
		TITLE(FontFamily.getDefaultFontFamily(), FontCharEncoding.getDefaultEncoding(), BaseFont.EMBEDDED, 11.0f, FontStyle.BOLD, null),
		TITLE9(FontFamily.getDefaultFontFamily(), FontCharEncoding.getDefaultEncoding(), BaseFont.EMBEDDED, 9.0f, FontStyle.UNDEFINED, null),
		TITLE12(FontFamily.getDefaultFontFamily(), FontCharEncoding.getDefaultEncoding(), BaseFont.EMBEDDED, 12.0f, FontStyle.BOLD, null),
		TITLE16(FontFamily.getDefaultFontFamily(), FontCharEncoding.getDefaultEncoding(), BaseFont.EMBEDDED, 16.0f, FontStyle.ITALIC, null),
		TITLE20(FontFamily.getDefaultFontFamily(), FontCharEncoding.getDefaultEncoding(), BaseFont.EMBEDDED, 20.0f, FontStyle.BOLD, null),
		HEAD(FontFamily.getDefaultFontFamily(), FontCharEncoding.getDefaultEncoding(), BaseFont.EMBEDDED, 8.0f, FontStyle.BOLD, null);

		private Font font;


		FontType(FontFamily fontFamily,
		         FontCharEncoding characterEncoding,
		         boolean embedded,
		         float size,
		         FontStyle style,
		         BaseColor color)
		{

			this.font = FontType.getFont(fontFamily, characterEncoding, embedded, size, style, color);

		}

		public Font getFont()
		{
			return font;
		}

		public Font getFont(FontStyle style)
		{
			Font f = new Font(this.font);
			f.setStyle(style.getValue());
			return f;
		}

		public Font getFont(float size)
		{
			Font f = new Font(this.font);
			f.setSize(size);
			return f;
		}

		public static Font getFont(FontFamily fontFamily,
		                           FontCharEncoding characterEncoding,
		                           boolean embedded,
		                           float size,
		                           FontStyle style,
		                           BaseColor color)
		{
			return FontFactory.getFont(fontFamily.getName(),
				characterEncoding.getName(),
				embedded,
				size,
				style.getValue(),
				color);
		}
	}

	public enum CellStyles
	{
		HEAD(new CellStyle().setHorizAlign(CellStyle.Align.CENTER)
			.setVertAlign(CellStyle.Align.MIDDLE)
			.setCellFont(FontType.HEAD.getFont())
			.setBorder(CellStyle.Border.BOX)
			.setBackgroundColor(Colors.HEAD.getColor())
		),
		TOTAL(new CellStyle().setHorizAlign(CellStyle.Align.CENTER)
			.setVertAlign(CellStyle.Align.MIDDLE)
			.setCellFont(FontType.TOTAL.getFont())
			.setBorder(CellStyle.Border.BOX)
		),
		ROW(new CellStyle().setVertAlign(CellStyle.Align.MIDDLE)
			.setCellFont(FontType.NORMAL.getFont())
			.setBorder(CellStyle.Border.BOX)
			.setAlternateColor(true)
			.setBackgroundColor(Colors.EVENROW.getColor()));

		private CellStyle style;

		CellStyles(CellStyle style)
		{
			this.style = style;
		}

		public CellStyle getStyle()
		{
			return new CellStyle(style);
		}

		public static CellStyle getRowStyle(ReportOptions reportOptions, int row)
		{
			CellStyle cell = ROW.getStyle();
			if(reportOptions != null)
			{
				if(reportOptions.isAlternateRow() && row >= 0)
				{
					boolean isEven = (row % 2 == 1);
					BaseColor c = isEven ? reportOptions.getOddBackColor() : reportOptions.getEvenBackColor();
					cell.setBackgroundColor(c);
				}
			}

			return cell;
		}
	}


	public enum Formats
	{
		NUMERO(Locale.ITALIAN, -1, false),
		INTERO(Locale.ITALIAN, 0, true),
		VIRGOLA(Locale.ITALIAN, 2, true),
		DATA(Locale.ITALIAN, "dd/MM/yyyy"),
		DATAANNO(Locale.ITALIAN, "yyyy"),
		DATAGIORNO(Locale.ITALIAN, "d"),
		DATAORA(Locale.ITALIAN, "dd/MM/yyyy HH:mm:ss"),
		DATAESTESA(Locale.ITALIAN, "d MMMM yyyy"),
		ORA(Locale.ITALIAN, "HH:mm:ss"),
		ORAMINUTI(Locale.ITALIAN, "HH:mm"),
		DATATITOLO("{0} - {1}");

		private Format formato;

		Formats(String formato)
		{
			this.formato = new MessageFormat(formato);
		}

		Formats(Locale locale, int numDecimali, boolean raggruppo1000)
		{
			this.formato = getFormatoNumero(locale, numDecimali, numDecimali, raggruppo1000);

		}

		Formats(Locale locale, String formato)
		{
			this.formato = new SimpleDateFormat(formato, DateFormatSymbols.getInstance(locale));
		}

		public Format getFormato()
		{
			return formato;
		}


		public String format(Object... arguments)
		{
			String result = "";
			if(arguments != null)
			{
				if(!(this.formato instanceof MessageFormat))
				{
					if(arguments.length > 0)
					{
						result = this.formato.format(arguments[0]);
					}
				}
				else
				{
					result = this.formato.format(arguments);
				}
			}

			return result;
		}


		public static NumberFormat getFormatoNumero(int numDec)
		{
			return getFormatoNumero(numDec, true);
		}

		public static NumberFormat getFormatoNumero(int numDec, boolean group1000)
		{
			return getFormatoNumero(numDec, numDec, group1000);
		}

		public static NumberFormat getFormatoNumero(int minDec, int maxDec, boolean group1000)
		{
			return getFormatoNumero(Locale.ITALIAN, minDec, maxDec, group1000);
		}

		public static NumberFormat getFormatoNumero(Locale locale, int minDec, int maxDec, boolean group1000)
		{
			NumberFormat nf = getFormatoNumero(locale, "");
			nf.setGroupingUsed(group1000);
			if(minDec >= 0)
			{
				nf.setMinimumFractionDigits(minDec);
			}
			if(maxDec >= 0)
			{
				nf.setMaximumFractionDigits(maxDec);
			}

			return nf;

		}

		public static NumberFormat getFormatoNumero()
		{
			return getFormatoNumero(Locale.ITALIAN, "");
		}

		public static NumberFormat getFormatoNumero(String formato)
		{
			return getFormatoNumero(Locale.ITALIAN, formato);
		}

		public static NumberFormat getFormatoNumero(Locale locale, String formato)
		{
			return new DecimalFormat(formato, DecimalFormatSymbols.getInstance(locale));
		}

		public static DateFormat getFormatoData()
		{
			return getFormatoData(Locale.ITALIAN, "");
		}

		public static DateFormat getFormatoData(String formato)
		{
			return getFormatoData(Locale.ITALIAN, formato);
		}

		public static DateFormat getFormatoData(Locale locale, String formato)
		{
			return new SimpleDateFormat(formato, DateFormatSymbols.getInstance(locale));
		}
	}

	public enum Colors
	{
		HEAD(new BaseColor(0.7f, 0.7f, 0.7f)),
		ODDROW(new BaseColor(0.8f, 0.8f, 0.8f)),
		TITLE(new BaseColor(0.8f, 0.8f, 0.8f)),
		EVENROW(null);
		private BaseColor color;

		Colors(BaseColor color)
		{
			this.color = color;
		}

		public BaseColor getColor()
		{
			return color != null ? new BaseColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()) : null;
		}
	}

	public enum Labels
	{
		TOTALE("Totale", "Tot."),
		TOTALEVOTIVALIDI("Totale voti validi", "Tot. voti validi"),
		VOTIVALIDI("Voti validi", "validi"),
		VOTIPREFERENZA("Voti di preferenza", "voti pref."),
		SEZIONE("Num. Sezione", "N. Sez."),
        PAGE("Pagina {0}", "Pag. {0}"),
        PAGE_TOTAL("Pag. {0} di {1}", "Pag. {0}/{1}"),
		PRINTED("Stampato il: {0}", null),
		CANDIDATO("Candidato", "Cand."),
		CANDIDATOSINDACO("Candidato Sindaco", "Cand. Sindaco"),
		CANDIDATISINDACO("Candidati Sindaco", "Cand. Sindaco"),
		CANDIDATOELETTOSINDACO("Candidato Eletto Sindaco", "Cand. Eletto Sindaco"),
		CANDIDATISINDACOELETTI("Candidati sindaco eletti consigliere", "Cand. sindaco eletti cons."),
		CANDIDATIELETTI("Candidati Eletti", "Cand. Eletti"),
		CANDIDATICONSIGLIERI("Candidati Consiglieri", "Cand. Consiglieri"),
		CANDIDATIELETTICONSIGLIERI("Candidati Eletti Consiglieri", "Cand. Eletti Consiglieri"),
		LISTA("Lista", null),
		LISTA2("Lista:", null),
		CIFRAELETTORALE("Cifra Elettorale:", "Cifra"),
		QUOZIENTI("Quozienti", "Quozienti"),
		CIFRAINDIVIDUALE("Cifra Individuale", "Cifra Ind."),
		DIVISO("Diviso per", "Diviso"),
		NUMEROSEGGI("Numero Seggi", "N. Seggi");

		private static final String SPAZIO = " ";

		private String etichetta;
		private String abbreviazione;

		Labels(String etichetta, String abbreviazione)
		{
			this.etichetta = etichetta;
			this.abbreviazione = abbreviazione;
		}

		public String getEtichetta()
		{
			return etichetta != null ? etichetta : "";
		}

		public String getAbbreviazione()
		{
			return abbreviazione != null ? abbreviazione : getEtichetta();
		}

		public String getEtichettaConcatena(Object s)
		{
			return concatena(getEtichetta(), s);
		}

		public String getAbbreviazioneConcatena(Object s)
		{
			return concatena(getAbbreviazione(), s);
		}

        public String getEtichettaFormatta(Object... s)
        {
            return formatta(getEtichetta(), s);
        }

        public String getAbbreviazioneFormatta(Object... s)
        {
            return formatta(getAbbreviazione(), s);
        }

        private String formatta(String label, Object...  s)
        {
            String m = null;
            if (label != null)
            {
                m = MessageFormat.format(label,s);
            }
            
            return m;
        }

        private String concatena(String s1, Object s2)
		{

			if(s1 != null && s1.length() > 0)
			{
				s1 = s1.concat(SPAZIO);
			}
			else
			{
				s1 = "";
			}
			String s = s2 != null ? s2.toString() : "";
			if(s.trim().length() > 0)
			{
				s1 = s1.concat(s);
			}

			return s1;
		}


	}

	private Styles()
	{ /* not istanziable */}
}
