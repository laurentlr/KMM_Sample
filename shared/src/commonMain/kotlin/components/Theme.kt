import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class FmOranges(
    val orange500Pressed: Color,
    val orange400Primary: Color,
    val orange300Pastel: Color,
    val orange200: Color,
    val orange100: Color,
)

@Immutable
data class FmReds(
    val red500Pressed: Color,
    val red400Primary: Color,
    val red300Pastel: Color,
    val red200: Color,
    val red100: Color,
)

@Immutable
data class FmGreens(
    val green500Pressed: Color,
    val green400Brand: Color,
    val green300Pastel: Color,
    val green200: Color,
    val green100: Color,
)

@Immutable
data class FmBlues(
    val blue800DebitCard: Color,
    val blue700Brand: Color,
    val blue600Pressed: Color,
    val blue500Primary: Color,
    val blue400Pastel: Color,
    val blue300: Color,
    val blue200BorderOutline: Color,
    val blue100LightBackground: Color,
)

@Immutable
data class FmCyans(
    val cyan600: Color,
    val cyan100: Color,
)

@Immutable
data class FmNeutrals(
    val black200TextPrimary: Color,
    val black100Pressed: Color,
    val grey300BodySecondary: Color,
    val grey200TitleSecondary: Color,
    val grey100Disabled: Color,
    val white400: Color,
    val white300Tertiary: Color,
    val white200Secondary: Color,
    val white100Primary: Color,
    val grey400ViewBorder: Color,
)

@Immutable
data class FmLegacyColors(
    val greenLegacyButton: Color,
    val greyLegacyDisabled: Color,
    val silverLegacy: Color,
    val lightGreenCardBackground: Color,
    val bronzeDark: Color,
    val purple: Color,
)

@Immutable
data class FmColors(
    val oranges: FmOranges,
    val reds: FmReds,
    val greens: FmGreens,
    val blues: FmBlues,
    val cyans: FmCyans,
    val neutrals: FmNeutrals,
    val legacyColors: FmLegacyColors,
)

@Immutable
data class FmDimens(
    val standard10: Dp,
    val standard25: Dp,
    val standard50: Dp,
    val standard75: Dp,
    val standard100: Dp,
    val standard125: Dp,
    val standard150: Dp,
    val standard175: Dp,
    val standard200: Dp,
    val standard225: Dp,
    val standard250: Dp,
    val standard275: Dp,
    val standard300: Dp,
    val standard325: Dp,
    val standard350: Dp,
    val standard400: Dp,
    val standard500: Dp,
    val standard600: Dp,
    val standard625: Dp,
    val standard700: Dp,
    val standard800: Dp,
    val standard1000: Dp,
    val standard1375: Dp,
    val standard1725: Dp,
)

@Immutable
data class FmTypography(
    val titleHero: TextStyle,
    val titleExtraLarge: TextStyle,
    val titleLarge: TextStyle,
    val titleBig: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val titleTiny: TextStyle,
    val titleTinySemi: TextStyle,
    val linkSmall: TextStyle,
    val linkTiny: TextStyle,
    val bodyBig: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
    val bodyTiny: TextStyle,
)

val dimens = FmDimens(
    standard10 = 2.dp,
    standard25 = 4.dp,
    standard50 = 8.dp,
    standard75 = 12.dp,
    standard100 = 16.dp,
    standard125 = 20.dp,
    standard150 = 24.dp,
    standard175 = 28.dp,
    standard200 = 32.dp,
    standard225 = 36.dp,
    standard250 = 40.dp,
    standard275 = 44.dp,
    standard300 = 48.dp,
    standard325 = 52.dp,
    standard350 = 56.dp,
    standard400 = 64.dp,
    standard500 = 80.dp,
    standard600 = 96.dp,
    standard625 = 100.dp,
    standard700 = 112.dp,
    standard800 = 128.dp,
    standard1000 = 184.dp,
    standard1375 = 220.dp,
    standard1725 = 276.dp
)

val colors = FmColors(
    oranges = FmOranges(
        orange500Pressed = Color(0xffFB9404),
        orange400Primary = Color(0xffFCA936),
        orange300Pastel = Color(0xffFFBE80),
        orange200 = Color(0xffFFE4CC),
        orange100 = Color(0xffFFF4EA),
    ),
    reds = FmReds(
        red500Pressed = Color(0xffBC1A3F),
        red400Primary = Color(0xffE12A53),
        red300Pastel = Color(0xffFF6767),
        red200 = Color(0xffFFD1D1),
        red100 = Color(0xffFFF5F5),
    ),
    greens = FmGreens(
        green500Pressed = Color(0xff2A7E5B),
        green400Brand = Color(0xff37A477),
        green300Pastel = Color(0xff3CBA67),
        green200 = Color(0xffD1F0DB),
        green100 = Color(0xffF0FBF6),
    ),
    blues = FmBlues(
        blue800DebitCard = Color(0xff171D32),
        blue700Brand = Color(0xff283655),
        blue600Pressed = Color(0xff1B48BB),
        blue500Primary = Color(0xff295DE0),
        blue400Pastel = Color(0xff678EF0),
        blue300 = Color(0xffADC4FF),
        blue200BorderOutline = Color(0xffE3EBF8),
        blue100LightBackground = Color(0xffF3F6FC),
    ),
    cyans = FmCyans(
        cyan600 = Color(0xff00ACD5),
        cyan100 = Color(0xffF5FDFF),
    ),
    neutrals = FmNeutrals(
        black200TextPrimary = Color(0xff1E1F26),
        black100Pressed = Color(0xff3F4050),
        grey300BodySecondary = Color(0xff61647B),
        grey200TitleSecondary = Color(0xff7D808F),
        grey100Disabled = Color(0xffB9BCC8),
        white400 = Color(0xffEAEAED),
        white300Tertiary = Color(0xffF2F2F5),
        white200Secondary = Color(0xffF7F7FA),
        white100Primary = Color(0xffFFFFFF),
        grey400ViewBorder = Color(0xffD9D9D9),
    ),
    legacyColors = FmLegacyColors(
        greenLegacyButton = Color(0xff42BB0C),
        greyLegacyDisabled = Color(0xffc4c4c4),
        silverLegacy = Color(0xff535395),
        lightGreenCardBackground = Color(0xfff0fbf6),
        bronzeDark = Color(0xff8c4d25),
        purple = Color(0xff8c4cca),
    ),
)

val typography = FmTypography(
    titleHero = TextStyle.Default.copy(
        fontSize = 28.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.Bold,
        color = colors.neutrals.black200TextPrimary,
    ),
    titleExtraLarge = TextStyle.Default.copy(
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.Bold,
        color = colors.neutrals.black200TextPrimary,
    ),
    titleLarge = TextStyle.Default.copy(
        fontSize = 21.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Bold,
        color = colors.neutrals.black200TextPrimary,
    ),
    titleBig = TextStyle.Default.copy(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold,
        color = colors.neutrals.black200TextPrimary,
    ),
    titleMedium = TextStyle.Default.copy(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold,
        color = colors.neutrals.black200TextPrimary,
    ),
    titleSmall = TextStyle.Default.copy(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Bold,
        color = colors.neutrals.black200TextPrimary,
    ),
    titleTiny = TextStyle.Default.copy(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Bold,
        color = colors.neutrals.black200TextPrimary,
    ),
    titleTinySemi = TextStyle.Default.copy(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.SemiBold,
        color = colors.neutrals.grey300BodySecondary,
    ),
    bodyBig = TextStyle.Default.copy(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal,
        color = colors.neutrals.grey300BodySecondary,
    ),
    bodyMedium = TextStyle.Default.copy(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal,
        color = colors.neutrals.grey300BodySecondary,
    ),
    bodySmall = TextStyle.Default.copy(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal,
        color = colors.neutrals.grey300BodySecondary,
    ),
    linkSmall = TextStyle.Default.copy(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Bold,
        color = colors.blues.blue500Primary,
        textDecoration = TextDecoration.Underline,
    ),
    bodyTiny = TextStyle.Default.copy(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Normal,
        color = colors.neutrals.grey300BodySecondary,
    ),
    linkTiny = TextStyle.Default.copy(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Bold,
        color = colors.blues.blue500Primary,
        textDecoration = TextDecoration.Underline,
    ),
)

