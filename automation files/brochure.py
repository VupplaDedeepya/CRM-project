from reportlab.lib.pagesizes import letter, landscape
from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Table, TableStyle
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.lib import colors

def create_brochure():
    # 1. Setup Document Layout (Landscape Letter size)
    pdf_filename = "star_homeopathy_brochure.pdf"
    doc = SimpleDocTemplate(
        pdf_filename,
        pagesize=landscape(letter),
        rightMargin=20, leftMargin=20,
        topMargin=20, bottomMargin=20
    )
    
    # 2. Define Color Palette
    PRIMARY_COLOR = colors.HexColor("#2C5E2E")   # Forest Green
    SECONDARY_COLOR = colors.HexColor("#4CAF50") # Leaf Green
    TEXT_COLOR = colors.HexColor("#333333")      # Charcoal
    LIGHT_BG = colors.HexColor("#F8F9FA")        # Warm White/Light Grey
    
    # 3. Typography Styles
    styles = getSampleStyleSheet()
    
    title_style = ParagraphStyle(
        'PanelTitle',
        parent=styles['Heading1'],
        fontName='Helvetica-Bold',
        fontSize=18,
        textColor=PRIMARY_COLOR,
        spaceAfter=4
    )
    
    section_heading = ParagraphStyle(
        'SectionHeading',
        parent=styles['Heading2'],
        fontName='Helvetica-Bold',
        fontSize=13,
        textColor=PRIMARY_COLOR,
        spaceBefore=8,
        spaceAfter=6,
        borderColor=SECONDARY_COLOR,
        borderWidth=1,
        borderPadding=2
    )
    
    body_style = ParagraphStyle(
        'BodyTextCustom',
        parent=styles['Normal'],
        fontName='Helvetica',
        fontSize=9.5,
        textColor=TEXT_COLOR,
        leading=13,
        spaceAfter=6
    )
    
    tagline_style = ParagraphStyle(
        'Tagline',
        parent=body_style,
        fontName='Helvetica-Oblique',
        textColor=colors.HexColor("#555555"),
        spaceAfter=8
    )
    
    bullet_style = ParagraphStyle(
        'BulletCustom',
        parent=body_style,
        leftIndent=12,
        firstLineIndent=-8,
        spaceAfter=4
    )
    
    disclaimer_style = ParagraphStyle(
        'Disclaimer',
        parent=body_style,
        fontName='Helvetica',
        fontSize=7,
        textColor=colors.HexColor("#777777"),
        leading=9,
        spaceBefore=12
    )

    story = []

    # --- PANEL 1: FRONT/ABOUT PANEL ---
    panel1_content = [
        Paragraph("<b>STAR HOMEOPATHY</b>", title_style),
        Paragraph("Healing Naturally. Restoring Balance.", tagline_style),
        Spacer(1, 10),
        Paragraph("<b>About Us</b>", section_heading),
        Paragraph(
            "Welcome to Star Homeopathy, where gentle, holistic healing meets modern wellness. "
            "Founded on the principle that the body knows how to heal itself, we provide individualized, "
            "natural care that addresses root causes—not just symptoms. Our certified practitioners take the time "
            "to listen, assess, and design a wellness plan tailored uniquely to you.", 
            body_style
        ),
        Spacer(1, 15),
        Paragraph("<b>Contact Details:</b>", body_style),
        Paragraph("📞 (555) 123-4567", body_style),
        Paragraph("🌐 www.starhomeopathy.com", body_style)
    ]

    # --- PANEL 2: INSIDE SERVICES ---
    panel2_content = [
        Paragraph("<b>Our Services</b>", section_heading),
        Spacer(1, 4),
        Paragraph("• Chronic Fatigue & Pain Management", bullet_style),
        Paragraph("• Allergies, Asthma & Immune Support", bullet_style),
        Paragraph("• Stress, Anxiety & Sleep Disorders", bullet_style),
        Paragraph("• Women’s & Men’s Hormonal Health", bullet_style),
        Paragraph("• Pediatric & Family Homeopathy", bullet_style),
        Paragraph("• Detox & Preventive Wellness Programs", bullet_style),
        Spacer(1, 10),
        Paragraph("<i>All remedies are highly diluted, non-toxic, and safe for all ages.</i>", body_style)
    ]

    # --- PANEL 3: WHY CHOOSE US / BACK ---
    panel3_content = [
        Paragraph("<b>Why Choose Star?</b>", section_heading),
        Spacer(1, 4),
        Paragraph("• 100% Natural & Non-Habit Forming", bullet_style),
        Paragraph("• Licensed & Experienced Practitioners", bullet_style),
        Paragraph("• In-Depth 60–90 Minute Initial Consults", bullet_style),
        Paragraph("• Integrative Approach (Complements care)", bullet_style),
        Paragraph("• Flexible In-Person & Telehealth Sessions", bullet_style),
        Spacer(1, 8),
        Paragraph("\"Your health is our star priority.\"", tagline_style),
        Spacer(1, 10),
        Paragraph("<b>Disclaimer:</b> Homeopathy is a complementary therapy. Always consult a licensed healthcare provider for medical diagnosis.", disclaimer_style)
    ]

    # 4. Construct Tri-Fold layout using a ReportLab Table
    # Total available width = 792 (letter width) - 40 (margins) = 752. Each panel gets ~244 width.
    data = [[panel1_content, panel2_content, panel3_content]]
    
    brochure_table = Table(data, colWidths=[244, 244, 244], rowHeights=[450])
    brochure_table.setStyle(TableStyle([
        ('BACKGROUND', (0,0), (-1,-1), LIGHT_BG),
        ('VALIGN', (0,0), (-1,-1), 'TOP'),
        ('TOPPADDING', (0,0), (-1,-1), 16),
        ('BOTTOMPADDING', (0,0), (-1,-1), 16),
        ('LEFTPADDING', (0,0), (-1,-1), 16),
        ('RIGHTPADDING', (0,0), (-1,-1), 16),
        # Elegant thin dashed divider lines simulating the tri-fold fold lines
        ('LINEAFTER', (0,0), (0,0), 1, colors.HexColor("#CCCCCC")),
        ('LINEAFTER', (1,0), (1,0), 1, colors.HexColor("#CCCCCC")),
    ]))
    
    story.append(brochure_table)
    
    # Build the document structure
    doc.build(story)
    print(f"Success! Native PDF generated and saved as '{pdf_filename}'.")

if __name__ == "__main__":
    create_brochure()