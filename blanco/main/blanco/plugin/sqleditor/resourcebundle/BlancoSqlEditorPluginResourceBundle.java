/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ���Ď�����������Ă��܂��B
 * ���\�[�X�o���h����`������쐬���ꂽ���\�[�X�o���h���N���X�B
 */
package blanco.plugin.sqleditor.resourcebundle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * ���\�[�X�o���h����`[BlancoSqlEditorPlugin]�̃��\�[�X�o���h���N���X�B
 *
 * ���̃N���X�̓��\�[�X�o���h����`�����玩���������ꂽ���\�[�X�o���h���N���X�ł��B<BR>
 * ���m�̃��P�[��<BR>
 * <UL>
 * <LI>en
 * <LI>ja
 * </UL>
 */
public class BlancoSqlEditorPluginResourceBundle {
    /**
     * ���\�[�X�o���h���I�u�W�F�N�g�B
     *
     * �����I�Ɏ��ۂɓ��͂��s�����\�[�X�o���h�����L�����܂��B
     */
    private ResourceBundle fResourceBundle;

    /**
     * BlancoSqlEditorPluginResourceBundle�N���X�̃R���X�g���N�^�B
     *
     * ��ꖼ[BlancoSqlEditorPlugin]�A�f�t�H���g�̃��P�[���A�Ăяo�����̃N���X���[�_���g�p���āA���\�[�X�o���h�����擾���܂��B
     */
    public BlancoSqlEditorPluginResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("BlancoSqlEditorPlugin");
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoSqlEditorPluginResourceBundle�N���X�̃R���X�g���N�^�B
     *
     * ��ꖼ[BlancoSqlEditorPlugin]�A�w�肳�ꂽ���P�[���A�Ăяo�����̃N���X���[�_���g�p���āA���\�[�X�o���h�����擾���܂��B
     *
     * @param locale ���P�[���̎w��
     */
    public BlancoSqlEditorPluginResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("BlancoSqlEditorPlugin", locale);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoSqlEditorPluginResourceBundle�N���X�̃R���X�g���N�^�B
     *
     * ��ꖼ[BlancoSqlEditorPlugin]�A�w�肳�ꂽ���P�[���A�w�肳�ꂽ�N���X���[�_���g�p���āA���\�[�X�o���h�����擾���܂��B
     *
     * @param locale ���P�[���̎w��
     * @param loader �N���X���[�_�̎w��
     */
    public BlancoSqlEditorPluginResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("BlancoSqlEditorPlugin", locale, loader);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * �����I�ɕێ����Ă��郊�\�[�X�o���h���I�u�W�F�N�g���擾���܂��B
     *
     * @return �����I�ɕێ����Ă��郊�\�[�X�o���h���I�u�W�F�N�g�B
     */
    public ResourceBundle getResourceBundle() {
        return fResourceBundle;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MENU0001]
     *
     * [&amp;SQL] (en)<br>
     * [SQL(&amp;S)] (ja)<br>
     *
     * @return key[MENU0001]�ɑΉ�����l�B�O������ǂݍ��݂��ł��Ȃ��ꍇ�ɂ́A��`���̒l��߂��܂��B�K��null�ȊO�̒l���߂�܂��B
     */
    public String getMenu0001() {
        // �����l�Ƃ��Ē�`���̒l�𗘗p���܂��B
        String strFormat = "&SQL";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MENU0001");
            }
        } catch (MissingResourceException ex) {
        }
        // �u��������͂ЂƂ�����܂���B
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MENU0002]
     *
     * [F&amp;ormat] (en)<br>
     * [�t�H�[�}�b�g(&amp;O)] (ja)<br>
     *
     * @return key[MENU0002]�ɑΉ�����l�B�O������ǂݍ��݂��ł��Ȃ��ꍇ�ɂ́A��`���̒l��߂��܂��B�K��null�ȊO�̒l���߂�܂��B
     */
    public String getMenu0002() {
        // �����l�Ƃ��Ē�`���̒l�𗘗p���܂��B
        String strFormat = "F&ormat";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MENU0002");
            }
        } catch (MissingResourceException ex) {
        }
        // �u��������͂ЂƂ�����܂���B
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MENU0002ToolTip]
     *
     * [Format SQL] (en)<br>
     * [SQL�𐮌`���܂�] (ja)<br>
     *
     * @return key[MENU0002ToolTip]�ɑΉ�����l�B�O������ǂݍ��݂��ł��Ȃ��ꍇ�ɂ́A��`���̒l��߂��܂��B�K��null�ȊO�̒l���߂�܂��B
     */
    public String getMENU0002ToolTip() {
        // �����l�Ƃ��Ē�`���̒l�𗘗p���܂��B
        String strFormat = "Format SQL";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MENU0002ToolTip");
            }
        } catch (MissingResourceException ex) {
        }
        // �u��������͂ЂƂ�����܂���B
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MSG0001]
     *
     * [Format SQL: begin.] (en)<br>
     * [SQL���`�����s�J�n���܂�.] (ja)<br>
     *
     * @return key[MSG0001]�ɑΉ�����l�B�O������ǂݍ��݂��ł��Ȃ��ꍇ�ɂ́A��`���̒l��߂��܂��B�K��null�ȊO�̒l���߂�܂��B
     */
    public String getMsg0001() {
        // �����l�Ƃ��Ē�`���̒l�𗘗p���܂��B
        String strFormat = "Format SQL: begin.";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MSG0001");
            }
        } catch (MissingResourceException ex) {
        }
        // �u��������͂ЂƂ�����܂���B
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MSG0002]
     *
     * [Format SQL: done.] (en)<br>
     * [SQL���`�����s����܂���.] (ja)<br>
     *
     * @return key[MSG0002]�ɑΉ�����l�B�O������ǂݍ��݂��ł��Ȃ��ꍇ�ɂ́A��`���̒l��߂��܂��B�K��null�ȊO�̒l���߂�܂��B
     */
    public String getMsg0002() {
        // �����l�Ƃ��Ē�`���̒l�𗘗p���܂��B
        String strFormat = "Format SQL: done.";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MSG0002");
            }
        } catch (MissingResourceException ex) {
        }
        // �u��������͂ЂƂ�����܂���B
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MSG0003]
     *
     * [Format SQL: no necessity to format.] (en)<br>
     * [SQL���`�̕K�v�͂���܂���.] (ja)<br>
     *
     * @return key[MSG0003]�ɑΉ�����l�B�O������ǂݍ��݂��ł��Ȃ��ꍇ�ɂ́A��`���̒l��߂��܂��B�K��null�ȊO�̒l���߂�܂��B
     */
    public String getMsg0003() {
        // �����l�Ƃ��Ē�`���̒l�𗘗p���܂��B
        String strFormat = "Format SQL: no necessity to format.";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MSG0003");
            }
        } catch (MissingResourceException ex) {
        }
        // �u��������͂ЂƂ�����܂���B
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MSG0004]
     *
     * [Format SQL: exception occurs during SQL formatting. Check SQL is valid.] (en)<br>
     * [SQL���`�̉ߒ��ŗ�O���������܂���. SQL�������������ǂ����`�F�b�N���Ă�������.] (ja)<br>
     *
     * @return key[MSG0004]�ɑΉ�����l�B�O������ǂݍ��݂��ł��Ȃ��ꍇ�ɂ́A��`���̒l��߂��܂��B�K��null�ȊO�̒l���߂�܂��B
     */
    public String getMsg0004() {
        // �����l�Ƃ��Ē�`���̒l�𗘗p���܂��B
        String strFormat = "Format SQL: exception occurs during SQL formatting. Check SQL is valid.";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MSG0004");
            }
        } catch (MissingResourceException ex) {
        }
        // �u��������͂ЂƂ�����܂���B
        return strFormat;
    }
}
