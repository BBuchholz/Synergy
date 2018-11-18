package com.nineworldsdeep.synergy

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_new_synergy_item.*


class NewSynergyItemActivity : AppCompatActivity() {

    private var etItemId: EditText? = null
    private var etItemValue: EditText? = null
    private var etItemType: EditText? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_synergy_item)
        etItemId = findViewById(R.id.etItemId)
        etItemValue = findViewById(R.id.etItemValue)
        etItemType = findViewById(R.id.etItemType)

        val button = findViewById<Button>(R.id.btnSave)
        button.setOnClickListener {

            val replyIntent = Intent()

            if (TextUtils.isEmpty(etItemId!!.text) ||
                    TextUtils.isEmpty(etItemValue!!.text) ||
                    TextUtils.isEmpty(etItemType!!.text)) {

                setResult(Activity.RESULT_CANCELED, replyIntent)

            } else {

                val itemId = etItemId!!.text.toString()
                val itemValue = etItemValue!!.text.toString()
                val itemType = etItemType!!.text.toString()

                replyIntent.putExtra(EXTRA_ITEM_ID, itemId)
                replyIntent.putExtra(EXTRA_ITEM_VALUE, itemValue)
                replyIntent.putExtra(EXTRA_ITEM_TYPE, itemType)

                setResult(Activity.RESULT_OK, replyIntent)
            }

            finish()
        }
    }

    companion object {

        val EXTRA_ITEM_ID = "com.nineworldsdeep.synergy.synergy_item_id"
        val EXTRA_ITEM_VALUE = "com.nineworldsdeep.synergy.synergy_item_value"
        val EXTRA_ITEM_TYPE = "com.nineworldsdeep.synergy.synergy_item_type"
    }
}
