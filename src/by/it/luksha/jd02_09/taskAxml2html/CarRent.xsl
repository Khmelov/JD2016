<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/CarRent">
        <table border="1">
            <tr>
                <td colspan="3">Name CarRent</td>

            </tr>
            <tr>
                <td>Address</td>
                <td>Phone</td>
                <td>Web</td>
            </tr>
            <tr>
                <td>
                    <xsl:template match="CarRent/Name">
                            </xsl:template>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3"></td>
            </tr>
        </table>
    </xsl:template>

    <xsl:template match="CarRent/Name">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

</xsl:stylesheet>